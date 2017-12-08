package com.qimiao.dao;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;

/**
 * �༭ͼƬ��dao�����ڲ�ѯ��ɾ��ͼƬurl ͬʱ����news������ͼƬ����
 * @author Administrator
 *
 */
public interface EditDao {
	//����ͼƬurl��ѯͼƬ���Ƿ���ڸ�ͼƬ(���ش���ͼƬ������)
	public Integer selectPicCount(@Param("picUrl") String picUrl);
	
	//����ͼƬurl��ͼƬ����ɾ����ͼƬ
	public boolean deletePic(@Param("picUrl") String picUrl);
	
	//��������Id����news����ͼƬ����(ÿ�μ�һ)
	public boolean updatePicTotal(@Param("newsId") Integer newsId);
	
	//����newsId����news��
	public boolean updateNews(@Param("news") News news);
	
	//����ͼƬ��
	public boolean updateImgTb(@Param("img") NewsImg img);
	
	//����newsIdɾ��ͼƬ�������в鵽������
	public boolean deleteImg(@Param("newsId") Integer newsId);
}
