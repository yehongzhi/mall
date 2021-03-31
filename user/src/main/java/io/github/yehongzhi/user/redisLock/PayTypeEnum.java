package io.github.yehongzhi.user.redisLock;

public enum PayTypeEnum {
    /**
     * 支付宝
     */
    ALI_PAY(1, "ALI_PAY"),
    /**
     * 微信支付
     */
    WECHAT_PAY(2, "WECHAT_PAY"),

    UNION_PAY(3,"UNION_PAY")
    ;

    private int code;

    private String describe;

    PayTypeEnum(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public PayTypeEnum find(int code) {
        for (PayTypeEnum payTypeEnum : values()) {
            payTypeEnum.name();
            payTypeEnum.ordinal();
            if (payTypeEnum.getCode() == code) {
                return payTypeEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
