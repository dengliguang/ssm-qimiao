package com.qimiao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Array;
import com.qimiao.bean.NewsTemp;

public class Test {
	public static void main(String[] args){
		Date d=new Date();
		System.out.println(d);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s=sdf.format(d);
		System.out.println(s);
	}
}
