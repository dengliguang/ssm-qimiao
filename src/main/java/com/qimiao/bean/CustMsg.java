package com.qimiao.bean;

import java.io.Serializable;
import java.util.Date;

public class CustMsg implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer msgId;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private String customerNeed;
	private Date time;
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerNeed() {
		return customerNeed;
	}
	public void setCustomerNeed(String customerNeed) {
		this.customerNeed = customerNeed;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "CustMsg [msgId=" + msgId + ", customerName=" + customerName + ", customerPhone=" + customerPhone
				+ ", customerEmail=" + customerEmail + ", customerNeed=" + customerNeed + ", time=" + time + "]";
	}
	
	
}
