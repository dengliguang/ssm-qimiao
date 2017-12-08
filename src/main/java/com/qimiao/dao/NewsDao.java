package com.qimiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;

/**
 * 查询新闻表(news_tb)
 * @author Administrator
 *
 */
@Mapper
public interface NewsDao {
	//根据title查询是否有重复的
	public Integer getCount(String title);
	
	//添加新闻
	public boolean addNews(@Param("news") News news);
	
	//添加到新闻图片表
	public boolean addNewsImg(@Param("img") NewsImg img);
	
	//查询新闻表信息接口
	public List<News> selectNews();
	
	//查询图片表信息接口
	public List<NewsImg> selectNewsImg(@Param("newsId") Integer newsId);
	
	//根据newsId查询新闻信息
	public News selectNewsByNewsId(@Param("newsId") Integer newsId);
	
	//根据新闻类型查询新闻信息
	public List<News> selectNewsByType(@Param("newsType") String newsType);
	
}
