package io.github.yehongzhi.commodity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.yehongzhi.commodity.mapper.TbCommodityInfoMapper;
import io.github.yehongzhi.commodity.service.TbCommodityInfoService;
import io.github.yehongzhi.model.TbCommodityInfo;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name TbCommodityInfoServiceImpl
 * @date 2020-07-13 22:42
 **/
@Service("commodityInfoService")
public class TbCommodityInfoServiceImpl extends ServiceImpl<TbCommodityInfoMapper, TbCommodityInfo> implements TbCommodityInfoService {

    @Resource(name = "tbCommodityInfoMapper")
    private TbCommodityInfoMapper commodityInfoMapper;

    @Override
    public List<TbCommodityInfo> getCommodityInfoList() throws Exception {
        return commodityInfoMapper.selectList(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ)
    public boolean insertCommodityInfo(String commodityName,
                                       String commodityPrice,
                                       String description,
                                       Integer number) throws Exception {
        TbCommodityInfo tbCommodityInfo = new TbCommodityInfo();
        tbCommodityInfo.setCommodityName(commodityName);
        tbCommodityInfo.setCommodityPrice(commodityPrice);
        tbCommodityInfo.setNumber(number);
        tbCommodityInfo.setDescription(description);
        return commodityInfoMapper.insert(tbCommodityInfo) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ)
    public synchronized boolean purchaseCommodityInfo(String commodityId, Integer number) throws Exception {
        //1.先查询数据库中商品的数量
        TbCommodityInfo commodityInfo = commodityInfoMapper.selectById(commodityId);
        //2.判断商品数量是否大于0，或者购买的数量大于库存
        Integer count = commodityInfo.getNumber();
        System.out.println("当前的库存是：" + count);
        if (count <= 0 || number > count) {
            //商品数量小于或者等于0，则返回false
            return false;
        }
        //3.如果商品数量大于0，并且购买的数量小于或者等于库存。则更新商品数量
        count -= number;
        commodityInfo.setNumber(count);

        commodityInfoMapper.updateByPK(commodityInfo);
        //如果更新成功，则打印购买商品成功
        System.out.println("购买商品[ " + commodityInfo.getCommodityName() + " ]成功,数量为：" + number + ",剩余库存为:" + count);
        return true;
    }

    @Override
    public boolean purchase(String commodityId, Integer number) throws Exception {
        boolean bool = false;
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        // 启动客户端
        client.start();
        InterProcessMutex mutex = new InterProcessMutex(client, "/locks");
        try {
            if (mutex.acquire(3, TimeUnit.SECONDS)) {
                bool = this.purchaseCommodityInfo(commodityId, number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            client.close();
        }
        return bool;
    }


}
