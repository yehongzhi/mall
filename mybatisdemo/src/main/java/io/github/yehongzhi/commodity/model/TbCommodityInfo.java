package io.github.yehongzhi.commodity.model;

import java.io.Serializable;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name TbCommodityInfo
 * @date 2020-11-03 23:27
 **/
public class TbCommodityInfo implements Serializable {

    private static final long serialVersionUID = -575258801669624015L;

    private String id;

    private String commodityName;

    private String commodityPrice;

    private String description;

    private Integer number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TbCommodityInfo{" +
                "id='" + id + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice='" + commodityPrice + '\'' +
                ", description='" + description + '\'' +
                ", number=" + number +
                '}';
    }
}
