package com.qimiao.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 对应新闻表
 * @author Administrator
 *
 */
public class News implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer newsId;
	private String title;
	private String type;
	private String content;
	private Date time;
	private Integer picTotal;
	private Integer status;
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getPicTotal() {
		return picTotal;
	}
	public void setPicTotal(Integer picTotal) {
		this.picTotal = picTotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", type=" + type + ", content=" + content + ", time="
				+ time + ", picTotal=" + picTotal + ", status=" + status + "]";
	}
	public News(Integer newsId, String title, String type, String content, Date time, Integer picTotal,
			Integer status) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.type = type;
		this.content = content;
		this.time = time;
		this.picTotal = picTotal;
		this.status = status;
	}
	public News(String title, String type, String content, Date time, Integer picTotal, Integer status) {
		super();
		this.title = title;
		this.type = type;
		this.content = content;
		this.time = time;
		this.picTotal = picTotal;
		this.status = status;
	}
	
	public News(){
		
	}

}
