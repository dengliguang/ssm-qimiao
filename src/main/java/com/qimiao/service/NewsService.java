package com.qimiao.service;

import java.util.List;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsTemp;
import com.qimiao.bean.ShowNews;
import com.qimiao.utils.Msg;

/**
 * ���Žӿ�
 * @author Administrator
 *
 */
public interface NewsService {
	//�������
	public Msg addNews(NewsTemp temp);
	
	//��ѯ���ű�
	
	//��ѯͼƬ��
	
	//չʾ������Ϣ(����ͼƬ)
	public Msg showNews(Integer pageNum);
	
	//��������Id��ѯ��������(����������ͼƬ)
	public ShowNews getContentNews(Integer newsId);

	//�����������Ͳ�ѯ������Ϣ
	public Msg getNewsByType(String newsType,Integer pageNum,String tab);
	
	//��������Id��ѯ���ź�ͼƬ����װshowNews
	public ShowNews getNewsByNewsId(Integer newsId);
	
	//����ͼƬurl��ɾ��ͼƬ�������ϵ�ͼƬ
	public Msg deletePic(String deleteSrc);
}

