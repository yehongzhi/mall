package io.github.yehongzhi.user.redisLock;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name PayTypeUtil
 * @date 2021-02-23 22:21
 **/
public class PayTypeUtil {
    //支付宝
    private static final int ALI_PAY = 1;
    //微信支付
    private static final int WECHAT_PAY = 2;

    //根据编码获取支付方式的名称
    public String getPayName(int code) {
        if (ALI_PAY == code) {
            return "Ali_Pay";
        }
        if (WECHAT_PAY == code) {
            return "Wechat_Pay";
        }
        return null;
    }
}
