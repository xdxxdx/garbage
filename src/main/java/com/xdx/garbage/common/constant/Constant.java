package com.xdx.garbage.common.constant;

public class Constant {

    public static final String defaultPwd="123456";
    //微信相关
    public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";//统一下单接口
    public static final String appId="wx591ae471bd6ee7ad";
    public static final String appSecret="fa762c002f452c5df06c2a4be070cb8d";
    //	public static final String appId="wxe35c79c931d8e742";//测试
//	public static final String appSecret="0cc6e7d746be57a9d2e1ec0d040eb805";//测试
    // 获取token接口(GET)
    public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
            + appId + "&secret=" + appSecret;
    public final static String OPENID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public final static String XCXCODDE_URL="https://api.weixin.qq.com/wxa/getwxacodeunlimit";//小程序码接口
    //排序
    //sort_num 必抢，sort_num1:个性化（在类别下的排序），sort_num2:精选，sort_num3:推荐
    public final static String qqmap_key="N7SBZ-5L5W5-ZT6IB-QRR52-MLCTQ-EXF45";//腾讯位置服务key
}
