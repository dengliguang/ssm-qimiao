package com.qimiao.dao;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;

/**
 * 编辑图片的dao：用于查询、删除图片url 同时更新news表里面图片总数
 * @author Administrator
 *
 */
public interface EditDao {
	//根据图片url查询图片表是否存在该图片(返回存在图片的数量)
	public Integer selectPicCount(@Param("picUrl") String picUrl);
	
	//根据图片url在图片表里删除该图片
	public boolean deletePic(@Param("picUrl") String picUrl);
	
	//根据新闻Id更新news表里图片总数(每次减一)
	public boolean updatePicTotal(@Param("newsId") Integer newsId);
	
	//根据newsId更新news表
	public boolean updateNews(@Param("news") News news);
	
	//更新图片表
	public boolean updateImgTb(@Param("img") NewsImg img);
	
	//根据newsId删除图片表里所有查到的数据
	public boolean deleteImg(@Param("newsId") Integer newsId);
}
