package com.xdx.garbage.common.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class OutPutMsg {
	/**
	 * 响应Ajax请求，返回消息
	 * 
	 * @param msg
	 */
	public static void outPutMsg(HttpServletResponse response, HttpServletRequest request, String msg) {
		response.setCharacterEncoding("utf-8");
		String sessionId = request.getSession().getId();
		response.setContentType("text/html; charset=UTF-8"); 
		response.setHeader("Set-Cookie", "JSESSIONID=" + sessionId);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(msg);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}

	public static void outPutMsg(HttpServletResponse response, String json) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(json);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}
}
