package com.qimiao.service;

import com.qimiao.bean.NewsTemp;
import com.qimiao.utils.Msg;

public interface EditService {
	//��ͼƬ�������ϣ�ɾ��ͼƬ
	public boolean deletePic(String deleteSrc,Integer newsId);
	
	//�������ݱ�news��ͼƬ��
	public Msg update(NewsTemp newsTemp);
}
