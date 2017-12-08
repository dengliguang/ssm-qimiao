package com.qimiao.bean;

import java.io.Serializable;

/**
 * 对应新闻图片表
 * @author Administrator
 *
 */
public class NewsImg implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer imgId;
	private String imgSrc;
	private Integer newsId;
	private Integer imgNum;
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public Integer getImgNum() {
		return imgNum;
	}
	public void setImgNum(Integer imgNum) {
		this.imgNum = imgNum;
	}
	@Override
	public String toString() {
		return "NewsImg [imgId=" + imgId + ", imgSrc=" + imgSrc + ", newsId=" + newsId + ", imgNum=" + imgNum + "]";
	}
	public NewsImg(String imgSrc, Integer newsId, Integer imgNum) {
		super();
		this.imgSrc = imgSrc;
		this.newsId = newsId;
		this.imgNum = imgNum;
	}
	public NewsImg() {
		super();
	}
	
}
