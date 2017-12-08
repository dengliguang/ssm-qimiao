package com.qimiao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getTime(Date date){
		//Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=sdf.format(date);
		return time;
	}
}
