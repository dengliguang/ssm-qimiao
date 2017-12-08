package com.qimiao.bean;

import java.util.Date;
import java.util.List;

public class ShowNews {
	private Integer newsId;
	private String title;
	private String type;
	private String content;
	private String time;
	private Integer picTotal;
	private List<String> imgList;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getPicTotal() {
		return picTotal;
	}
	public void setPicTotal(Integer picTotal) {
		this.picTotal = picTotal;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public ShowNews(Integer newsId, String title, String type, String content, String time, Integer picTotal,
			List<String> imgList, Integer status) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.type = type;
		this.content = content;
		this.time = time;
		this.picTotal = picTotal;
		this.imgList = imgList;
		this.status = status;
	}
	public ShowNews() {
		super();
	}
	@Override
	public String toString() {
		return "ShowNews [newsId=" + newsId + ", title=" + title + ", type=" + type + ", content=" + content + ", time="
				+ time + ", picTotal=" + picTotal + ", imgList=" + imgList + "]";
	}
	
	
	
}
