package io.github.yehongzhi.ordernacos.order;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name OrderController
 * @date 2020-09-26 14:48
 **/
@RestController
@RequestMapping("/mall/orderNacos")
public class OrderController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/callUser")
    public String callUser() {
        ServiceInstance instance = loadBalancerClient.choose("usernacos");
        String url = instance.getUri().toString() + "/mall/userNacos/list";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "调用" + instance.getServiceId() + "服务，端口号：" + instance.getPort() + ",返回结果：" + result;
    }
}
