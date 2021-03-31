package io.github.yehongzhi.springmvc;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import io.github.yehongzhi.springmvc.sentinel.UserController;
import io.github.yehongzhi.springmvc.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "io.github.yehongzhi.springmvc.mapper")
@EnableTransactionManagement
public class SpringmvcApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringmvcApplication.class, args);
        //initFlowQpsRule();
        //applicationContext.publishEvent(new PayApplicationEvent(applicationContext,"成功支付100元！"));
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
