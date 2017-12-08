package com.qimiao.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 新闻临时bean---用于接收页面传来的数据,并根据该bean封装News、NewsImg
 * @author Administrator
 *
 */
public class NewsTemp {
	private Integer newsId;
	private String title;
	private String type;
	private String content;
	private Date time;
	private String imgSrc;
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
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "NewsTemp [newsId=" + newsId + ", title=" + title + ", type=" + type + ", content=" + content + ", time="
				+ time + ", imgSrc=" + imgSrc + ", status=" + status + "]";
	}
	
	
	
	
}
