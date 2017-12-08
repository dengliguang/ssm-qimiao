package com.qimiao.service.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qimiao.service.ImgUploadService;
import com.qimiao.utils.Msg;
import com.qimiao.utils.PicUploadUtil;
/**
 * 图片上传到服务器，并返回给页面URL
 * @author Administrator
 *
 */
@Service
public class ImgUploadServiceImpl implements ImgUploadService {
	@Value("${backNames}")
	private String backNames;
	
	@Value("${picSize}")
	private long picSize;
	
	@Value("${picPath}")
	private String picPath;
	
	@Value("${picUrl}")
	private String picUrl;
	
	@Override
	public Msg imgUpload(MultipartFile file) {
		//1、判空
		boolean emp=PicUploadUtil.isEmpty(file);
		if(!emp){
			return Msg.failure().add("msg", "请上传图片！");
		}
		//1、图片格式判断
		boolean type=PicUploadUtil.picType(file, backNames);
		if(!type){
			return Msg.failure().add("msg", "图片格式有误！");
		}
		//2、图片大小判断
		boolean size=PicUploadUtil.picSize(file,picSize);
		if(!size){
			return Msg.failure().add("msg", "图片大小不能超过1MB！");
		}
		//4、图片名字
		String picName=PicUploadUtil.createName(file);
		//3、上传到服务器
		File f=new File(picPath+picName);
		try {
			file.transferTo(f);
			System.out.println("--------------------------");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4、返回给页面图片url地址
		String url=picUrl+picName;
		//System.out.println(url);
		return Msg.success().add("msg", url);
	}

}
