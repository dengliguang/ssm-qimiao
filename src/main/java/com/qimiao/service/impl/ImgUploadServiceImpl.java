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
 * ͼƬ�ϴ����������������ظ�ҳ��URL
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
		//1���п�
		boolean emp=PicUploadUtil.isEmpty(file);
		if(!emp){
			return Msg.failure().add("msg", "���ϴ�ͼƬ��");
		}
		//1��ͼƬ��ʽ�ж�
		boolean type=PicUploadUtil.picType(file, backNames);
		if(!type){
			return Msg.failure().add("msg", "ͼƬ��ʽ����");
		}
		//2��ͼƬ��С�ж�
		boolean size=PicUploadUtil.picSize(file,picSize);
		if(!size){
			return Msg.failure().add("msg", "ͼƬ��С���ܳ���1MB��");
		}
		//4��ͼƬ����
		String picName=PicUploadUtil.createName(file);
		//3���ϴ���������
		File f=new File(picPath+picName);
		try {
			file.transferTo(f);
			System.out.println("--------------------------");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4�����ظ�ҳ��ͼƬurl��ַ
		String url=picUrl+picName;
		//System.out.println(url);
		return Msg.success().add("msg", url);
	}

}
