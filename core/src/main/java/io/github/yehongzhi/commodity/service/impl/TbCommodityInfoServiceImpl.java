package io.github.yehongzhi.commodity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.yehongzhi.commodity.mapper.TbCommodityInfoMapper;
import io.github.yehongzhi.commodity.service.TbCommodityInfoService;
import io.github.yehongzhi.model.TbCommodityInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name TbCommodityInfoServiceImpl
 * @date 2020-07-13 22:42
 **/
@Service("commodityInfoService")
@Transactional(rollbackFor = Exception.class)
public class TbCommodityInfoServiceImpl extends ServiceImpl<TbCommodityInfoMapper, TbCommodityInfo> implements TbCommodityInfoService {

    @Resource(name = "tbCommodityInfoMapper")
    private TbCommodityInfoMapper commodityInfoMapper;

    @Override
    public List<TbCommodityInfo> getCommodityInfoList() throws Exception {
        return commodityInfoMapper.selectList(null);
    }

    @Override
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
    public boolean purchaseCommodityInfo(String commodityId, Integer number) throws Exception {
        //1.先查询数据库中商品的数量
        TbCommodityInfo commodityInfo = commodityInfoMapper.selectById(commodityId);
        //2.判断商品数量是否大于0，或者购买的数量大于库存
        Integer count = commodityInfo.getNumber();
        if (count <= 0 || number > count) {
            //商品数量小于或者等于0，则返回false
            return false;
        }
        //3.如果商品数量大于0，并且购买的数量小于或者等于库存。则更新商品数量
        count--;
        commodityInfo.setNumber(count);
        return commodityInfoMapper.updateById(commodityInfo) == 1;
    }

}
