package io.github.yehongzhi.commodity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name CommodityControllerTest
 * @date 2020-07-14 22:28
 **/
public class CommodityControllerTest {

    public static void main(String[] args) throws Exception {
        //请求地址
        String url = "http://localhost:%s/mall/commodity/purchase";
        //请求参数，商品ID，数量
        Map<String, String> map = new HashMap<>();
        map.put("commodityId", "4f863bb5266b9508e0c1f28c61ea8de1");
        map.put("number", "1");
        //创建10个线程通过HttpClient进行发送请求，测试
        for (int i = 0; i < 10; i++) {
            //8080、8081交替请求
            String port = "808" + (i % 2);
            CommodityThread commodityThread = new CommodityThread(String.format(url, port), map);
            commodityThread.start();
        }
    }
}
