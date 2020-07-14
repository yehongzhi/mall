package io.github.yehongzhi.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.yehongzhi.model.TbCommodityInfo;

import java.util.List;

public interface TbCommodityInfoService extends IService<TbCommodityInfo> {

    /**
     * 查询所有商品
     *
     * @return List<TbCommodityInfo>
     * @author java技术爱好者
     */
    List<TbCommodityInfo> getCommodityInfoList() throws Exception;

    /**
     * 新增商品
     *
     * @param commodityName  商品名称
     * @param commodityPrice 商品价格
     * @param description    商品描述
     * @param number         商品数量
     * @return boolean
     * @author java技术爱好者
     */
    boolean insertCommodityInfo(String commodityName, String commodityPrice, String description, Integer number) throws Exception;

    /**
     * 购买商品
     *
     * @param commodityId 商品Id
     * @param number      商品数量
     * @return boolean
     * @author java技术爱好者
     */
    boolean purchaseCommodityInfo(String commodityId, Integer number) throws Exception;
}
