package io.github.yehongzhi.springmvc;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.github.yehongzhi.springmvc.sentinel.UserController;
import io.github.yehongzhi.springmvc.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
@MapperScan(basePackages = "io.github.yehongzhi.springmvc.mapper")
@EnableTransactionManagement
public class SpringmvcApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringmvcApplication.class, args);
        loadMyNamespaceRules();
        //initFlowQpsRule();
        //applicationContext.publishEvent(new PayApplicationEvent(applicationContext,"成功支付100元！"));
    }

    private static void loadRules() {
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>("127.0.0.1:8848", "SENTINEL_GROUP", "springmvc-sentinel-flow-rules",
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

    private static void loadMyNamespaceRules() {
        Properties properties = new Properties();
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("namespace", "05f447bc-8a0b-4686-9c34-344d7206ea94");

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(properties, "SENTINEL_GROUP", "springmvc-sentinel-flow-rules",
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

    private static void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        rules.add(getFlowRule(UserController.RESOURCE_NAME, 2));
        rules.add(getFlowRule(UserController.RESOURCE_NAME_QUERY_USER_BY_ID, 1));
        rules.add(getFlowRule(UserServiceImpl.RESOURCE_NAME_QUERY_USER_BY_NAME, 1));
        FlowRuleManager.loadRules(rules);
    }

    private static FlowRule getFlowRule(String resourceName, int count) {
        FlowRule rule = new FlowRule(resourceName);
        rule.setCount(count);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        return rule;
    }
}
