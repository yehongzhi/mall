package io.github.yehongzhi.order.order;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name OrderController
 * @date 2020-09-24 22:37
 **/
@RestController
@RequestMapping("/mall/order")
public class OrderController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/callUser")
    public String list() throws Exception {
        //获取user服务实例
        ServiceInstance instance = loadBalancerClient.choose("user");
        //调用user服务
        String userList = new RestTemplate().getForObject(instance.getUri().toString() + "/mall/user/list", String.class);
        return "调用" + instance.getServiceId() + "服务，端口号：" + instance.getPort() + ",返回结果：" + userList;
    }
}
