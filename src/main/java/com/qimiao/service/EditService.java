package com.qimiao.service;

import com.qimiao.bean.NewsTemp;
import com.qimiao.utils.Msg;

public interface EditService {
	//在图片服务器上：删除图片
	public boolean deletePic(String deleteSrc,Integer newsId);
	
	//更新数据表：news表、图片表
	public Msg update(NewsTemp newsTemp);
}
