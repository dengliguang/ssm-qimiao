package com.qimiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qimiao.service.ImgUploadService;
import com.qimiao.utils.Msg;
import com.qimiao.utils.PicUploadUtil;
/**
 * 图片上传
 * @author Administrator
 *
 */
@Controller
public class ImgUploadController {
	
	@Autowired
	private ImgUploadService imgUploadService;
	
	//自定义图片上传(封面图片上传)
	@RequestMapping(value="/background/news/img",method=RequestMethod.POST)
	@ResponseBody
	public Msg imgUpload(@RequestParam(value="fileName",defaultValue="null")MultipartFile file){
		Msg strMsg=imgUploadService.imgUpload(file);
		System.out.println(strMsg.getCode()+"---"+strMsg.getMsg()+"---"+strMsg.getExtend().get("msg"));
		//System.out.println();
		return strMsg;
	}
	
	//富文本编辑器图片上传    
	@RequestMapping(value="/background/news/pic",method=RequestMethod.POST)
	@ResponseBody
	public String wangEditorPicUpload(@RequestParam(value="fileName",defaultValue="null")MultipartFile file){
		Msg strMsg=imgUploadService.imgUpload(file);
		System.out.println(strMsg.getCode()+"---"+strMsg.getMsg()+"---"+strMsg.getExtend().get("msg"));
		String picUrl=(String) strMsg.getExtend().get("msg");
		return picUrl;
	}
}
