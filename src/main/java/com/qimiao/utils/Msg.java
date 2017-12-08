package com.qimiao.utils;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//状态码：100 成功    200 失败
	private Integer code;
	//状态信息：
	private String msg;
	//需要返回给浏览器的数据
	private Map<String,Object> extend=new HashMap<String,Object>();
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	//处理成功信息
	public static Msg success(){
		Msg result=new Msg();
		result.setCode(100);
		result.setMsg("处理成功！");
		return result;
	}
	//处理失败信息
	public static Msg failure(){
		Msg result=new Msg();
		result.setCode(200);
		result.setMsg("处理失败！");
		return result;
	}
	//添加需要返回给浏览器的数据
	public Msg add(String str,Object obj){
		this.getExtend().put(str, obj);
		return this;
	}
}
