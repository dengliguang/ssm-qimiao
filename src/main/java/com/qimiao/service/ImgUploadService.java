package com.qimiao.service;

import org.springframework.web.multipart.MultipartFile;

import com.qimiao.utils.Msg;

public interface ImgUploadService {
	//Í¼Æ¬ÉÏ´«
	public Msg imgUpload(MultipartFile file);
	
}
