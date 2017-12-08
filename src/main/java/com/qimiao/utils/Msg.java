package com.qimiao.utils;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//״̬�룺100 �ɹ�    200 ʧ��
	private Integer code;
	//״̬��Ϣ��
	private String msg;
	//��Ҫ���ظ������������
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
	//����ɹ���Ϣ
	public static Msg success(){
		Msg result=new Msg();
		result.setCode(100);
		result.setMsg("����ɹ���");
		return result;
	}
	//����ʧ����Ϣ
	public static Msg failure(){
		Msg result=new Msg();
		result.setCode(200);
		result.setMsg("����ʧ�ܣ�");
		return result;
	}
	//�����Ҫ���ظ������������
	public Msg add(String str,Object obj){
		this.getExtend().put(str, obj);
		return this;
	}
}
