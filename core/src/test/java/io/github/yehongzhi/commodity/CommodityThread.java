package io.github.yehongzhi.commodity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name CommodityThread
 * @date 2020-07-14 22:29
 **/
public class CommodityThread extends Thread {

    //请求地址
    private String url;

    //请求参数
    private Map<String, String> paramMap;

    private volatile static AtomicInteger count = new AtomicInteger(0);

    public CommodityThread(String url, Map<String, String> paramMap) {
        this.url = url;
        this.paramMap = paramMap;
    }

    @Override
    public void run() {
        HttpClient client = null;
        try {
            List<NameValuePair> params = new ArrayList<>();
            //填充请求参数
            for (Map.Entry<String, String> entry : this.paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpEntity reqEntity = new UrlEncodedFormEntity(params, "utf-8");
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                    .setSocketTimeout(5000)// 二、读取数据超时：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间
                    .setConnectionRequestTimeout(5000)
                    .build();
            client = new DefaultHttpClient();
            //设置请求地址
            HttpPost post = new HttpPost(this.url);
            post.setEntity(reqEntity);
            post.setConfig(requestConfig);
            //发送请求
            HttpResponse response = client.execute(post);
            //获取响应结果
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity resEntity = response.getEntity();
                String message = EntityUtils.toString(resEntity, "utf-8");
                System.out.println("=============================================");
                System.out.println("true".equals(message) ? "购买成功" : "购买失败");
                System.out.println("=============================================");
            } else {
                System.out.println("请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                ((DefaultHttpClient) client).close();
            }
        }
    }
}
