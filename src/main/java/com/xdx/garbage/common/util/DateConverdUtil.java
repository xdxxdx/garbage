package com.xdx.garbage.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverdUtil {
	public final static String FORMART_YYYY_MM_DD = "yyyy-MM-dd";

	public final static String FORMART_YYYY_MM_DD_HH = "yyyy-MM-dd HH";

	public final static String FORMART_DDMMYYYY = "dd/MM/yyyy";

	public final static String FORMART_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public final static String SQL_FORMART_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh24:mi:ss";

	public final static String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	public final static String FORMART_YYYYMMDDHHMM = "yyyyMMddHHmm";

	public static DateFormat getDateFormart() {
		return getDateFormart(FORMART_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 方法概要:将String转Date
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date toDate(String date) {
		DateFormat df = getDateFormart();
		Date da = null;
		try {
			da = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}

	/**
	 * 方法概要:将String转Date
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date toDate(String date, String format) {
		DateFormat df = getDateFormart(format);
		Date da = null;
		try {
			da = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}

	/**
	 * 方法概要:获取格式信息
	 * 
	 * @param format
	 * @return
	 */
	public static DateFormat getDateFormart(String format) {
		DateFormat df = null;
		if (format == null || format.trim().equals("")) {
			df = new SimpleDateFormat(FORMART_YYYY_MM_DD_HH_MM_SS);
		} else {
			df = new SimpleDateFormat(format);
		}
		return df;
	}

	/**
	 * 方法概要:将日期转换为String串
	 * 
	 * @param dt
	 * @param sFmt
	 * @return
	 */
	public static String toString(Date dt, String sFmt) {
		if (dt == null)
			return "";
		else {
			SimpleDateFormat formatter = new SimpleDateFormat(sFmt);
			String sRet = formatter.format(dt).toString();
			return sRet;
		}
	}

	/**
	 * 方法概要:增加年
	 * 
	 * @param date
	 * @param years
	 * @return
	 */
	public static Date addYears(Date date, int years) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + years);// 让日期加1
		date = calendar.getTime();
		return date;
	}

	/**
	 * 方法概要:增加月
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonths(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + months);// 让日期加1
		date = calendar.getTime();
		return date;
	}

	/**
	 * 方法概要:增加日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);// 让日期加1
		date = calendar.getTime();
		return date;
	}

	/**
	 * 方法概要:增加小时
	 * 
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Date addHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hours);// 让日期加1
		date = calendar.getTime();
		return date;
	}

	/**
	 * 方法概要:增加分钟
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);// 让日期加1
		date = calendar.getTime();
		return date;
	}

	/**
	 * 方法概要:将日期转换为String串
	 * 
	 * @param dt
	 * @return
	 */
	public static String toString(Date dt) {
		return toString(dt, FORMART_YYYY_MM_DD_HH_MM_SS);
	}

}
