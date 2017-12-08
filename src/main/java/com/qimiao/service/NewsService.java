package com.qimiao.service;

import java.util.List;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsTemp;
import com.qimiao.bean.ShowNews;
import com.qimiao.utils.Msg;

/**
 * 新闻接口
 * @author Administrator
 *
 */
public interface NewsService {
	//添加新闻
	public Msg addNews(NewsTemp temp);
	
	//查询新闻表
	
	//查询图片表
	
	//展示新闻信息(包含图片)
	public Msg showNews(Integer pageNum);
	
	//根据新闻Id查询新闻内容(不包含封面图片)
	public ShowNews getContentNews(Integer newsId);

	//根据新闻类型查询新闻信息
	public Msg getNewsByType(String newsType,Integer pageNum,String tab);
	
	//根据新闻Id查询新闻和图片表，封装showNews
	public ShowNews getNewsByNewsId(Integer newsId);
	
	//根据图片url，删除图片服务器上的图片
	public Msg deletePic(String deleteSrc);
}

