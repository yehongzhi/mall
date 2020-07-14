package io.github.yehongzhi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name TbCommodityInfo
 * @date 2020-07-13 22:20
 **/
public class TbCommodityInfo implements Serializable {

    private static final long serialVersionUID = -395630902236009334L;

    //自动生成32位的UUID
    @TableId(type = IdType.UUID)
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
}
