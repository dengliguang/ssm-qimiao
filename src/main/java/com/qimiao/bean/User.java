package com.qimiao.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 对应用户表
 * @author Administrator
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userPhone;
	private String password;
	private Date time;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPhone=" + userPhone + ", password=" + password + ", time=" + time
				+ "]";
	}
	
	
	
	
}
