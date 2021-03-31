package io.github.yehongzhi.springmvc.config;

import com.alibaba.csp.sentinel.datasource.FileRefreshableDataSource;
import com.alibaba.csp.sentinel.datasource.FileWritableDataSource;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.transport.util.WritableDataSourceRegistry;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name FileDataSourceInit
 * @date 2021-03-30 22:54
 **/
public class FileDataSourceInit implements InitFunc {

    public FileDataSourceInit() {
    }

    @Override
    public void init() throws Exception {
        String filePath = System.getProperty("user.home") + "\\sentinel\\rules\\sentinel.json";
        ReadableDataSource<String, List<FlowRule>> ds = new FileRefreshableDataSource<>(
                filePath, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
        })
        );
        // 将可读数据源注册至 FlowRuleManager.
        FlowRuleManager.register2Property(ds.getProperty());

        WritableDataSource<List<FlowRule>> wds = new FileWritableDataSource<>(filePath, this::encodeJson);
        // 将可写数据源注册至 transport 模块的 WritableDataSourceRegistry 中.
        // 这样收到控制台推送的规则时，Sentinel 会先更新到内存，然后将规则写入到文件中.
        WritableDataSourceRegistry.registerFlowDataSource(wds);
    }

    private <T> String encodeJson(T t) {
        return JSON.toJSONString(t);
    }

}
