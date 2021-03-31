package io.github.yehongzhi.commodity;

import io.github.yehongzhi.commodity.mapper.TbCommodityInfoMapper;
import io.github.yehongzhi.commodity.model.TbCommodityInfo;
import io.github.yehongzhi.commodity.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name Test
 * @date 2020-11-03 23:29
 **/
public class Test {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        TbCommodityInfoMapper tbCommodityInfoMapper = sqlSession.getMapper(TbCommodityInfoMapper.class);
        List<TbCommodityInfo> commodityInfoList = tbCommodityInfoMapper.list();
        if (commodityInfoList != null && commodityInfoList.size() > 0) {
            for (TbCommodityInfo tbCommodityInfo : commodityInfoList) {
                System.out.println(tbCommodityInfo);
            }
        }
    }
}
