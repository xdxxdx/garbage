package com.xdx.garbage.common.util.wechatUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

/**
 * 小程序加密解密主调程序
 * 
 * @author xdx
 *
 */
public class WXDecrypt {
	private static final String WATERMARK = "watermark";
	private static final String APPID = "appid";

	/**
	 * 解密数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String appId, String encryptedData,
			String sessionKey, String iv) {
		String result = "";
		try {
			AES aes = new AES();
			byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData),
					Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
			if (null != resultByte && resultByte.length > 0) {
				result = new String(WxPKCS7Encoder.decode(resultByte), "utf-8");
				JSONObject jsonObject = JSON.parseObject(result);
				String decryptAppid = jsonObject.getJSONObject(WATERMARK)
						.getString(APPID);
				if (!appId.equals(decryptAppid)) {
					result = "";
				}
			}
		} catch (Exception e) {
			result = "";
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		String appId = "wxe35c79c931d8e742";
		String encryptedData = "AIWllHlBSWk5eIAvM20eWo6PCwH9JyFAZBseW368G7ZDrhAamkROEC82GIzw8a6vhGfBsASgUnjZuBOM6UEeHgl + Rcx7ZqQVTd + qb2V3iLbICnBwaBGouX + neq6LTHWXsBTjxe8sxzjP0aqOS0zQo3Zp62eR6EpWLNfVHA7v62XQ5XmZ3JGBo8YRbAz922RVK4ujybiMxG4XxNDC6au8KBMh7dJKYbjbxbrzRr / B5xrLQ7Hj9RPwilmjGstNO3jYRny + ds6Y3ZLqr1IHHIyVtusk0Ne0e6kPUoVyvUCKCJhnBo4vCv67KeAk56u8F7AJar1BA9upK2lNd0Nc + YbvgxfvrcVbJiytQv3twKpHzNVz + VCUfY8GenEmilaRpD62xiIJuV / QuApp5 + gnhUaZji6 + G / q90gb7InpAPux1PQaxaQSBtYv2ZEhjCssOuIBcM + 4 Qx30loGe5IfASWYK4dGwyo7GgdRB1n8NDFJium8fbS7NOqHgO / VlTwyw4dr6aFwesGROA9g75ge076kU0gA ==";
		String sessionKey = "IhZYG3ejTd/QdfKo42fkZA==";
		String iv = "t72uk9mkWTOqI2jIo3hGCw ==";
		System.out.println(decrypt(appId, encryptedData, sessionKey, iv));
	}
}
