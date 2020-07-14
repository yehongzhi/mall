package io.github.yehongzhi.commodity.controller;

import io.github.yehongzhi.commodity.service.TbCommodityInfoService;
import io.github.yehongzhi.model.TbCommodityInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品模块Controller层
 *
 * @author java技术爱好者
 * @name CommodityCtl
 * @date 2020-07-11 22:53
 **/
@RestController
@RequestMapping("/mall/commodity")
public class CommodityController {

    @Resource(name = "commodityInfoService")
    private TbCommodityInfoService commodityInfoService;

    /**
     * 获取所有商品列表
     *
     * @return List<TbCommodityInfo> 商品列表
     * @author java技术爱好者
     */
    @RequestMapping("/list")
    public List<TbCommodityInfo> getCommodityInfoList() throws Exception {
        return commodityInfoService.getCommodityInfoList();
    }

    /**
     * 添加商品
     *
     * @param commodityName  商品名称
     * @param commodityPrice 商品价格
     * @param description    商品价格
     * @param number         商品数量
     * @return boolean 是否添加成功
     * @author java技术爱好者
     */
    @PostMapping("/insert")
    public boolean insertCommodityInfo(@RequestParam(name = "commodityName") String commodityName,
                                       @RequestParam(name = "commodityPrice") String commodityPrice,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "number") Integer number) throws Exception {
        return commodityInfoService.insertCommodityInfo(commodityName, commodityPrice, description, number);
    }

    /**
     * 购买商品
     *
     * @param commodityId 商品ID
     * @param number      商品数量
     * @return boolean 是否购买成功
     * @author java技术爱好者
     */
    @PostMapping("/purchase")
    public boolean purchaseCommodityInfo(@RequestParam(name = "commodityId") String commodityId,
                                         @RequestParam(name = "number") Integer number) throws Exception {
        return commodityInfoService.purchaseCommodityInfo(commodityId, number);
    }
}
