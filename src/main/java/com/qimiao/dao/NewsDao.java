package com.qimiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;

/**
 * ��ѯ���ű�(news_tb)
 * @author Administrator
 *
 */
@Mapper
public interface NewsDao {
	//����title��ѯ�Ƿ����ظ���
	public Integer getCount(String title);
	
	//�������
	public boolean addNews(@Param("news") News news);
	
	//��ӵ�����ͼƬ��
	public boolean addNewsImg(@Param("img") NewsImg img);
	
	//��ѯ���ű���Ϣ�ӿ�
	public List<News> selectNews();
	
	//��ѯͼƬ����Ϣ�ӿ�
	public List<NewsImg> selectNewsImg(@Param("newsId") Integer newsId);
	
	//����newsId��ѯ������Ϣ
	public News selectNewsByNewsId(@Param("newsId") Integer newsId);
	
	//�����������Ͳ�ѯ������Ϣ
	public List<News> selectNewsByType(@Param("newsType") String newsType);
	
}
