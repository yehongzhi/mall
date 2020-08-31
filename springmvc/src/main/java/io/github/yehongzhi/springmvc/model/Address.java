package io.github.yehongzhi.springmvc.model;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name Address
 * @date 2020-08-26 23:31
 **/
public class Address {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
