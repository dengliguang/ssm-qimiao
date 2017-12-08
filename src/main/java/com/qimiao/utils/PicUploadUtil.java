package com.qimiao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * ͼƬ�ϴ������ࣺ��װ�����¼��ַ���
 * 1��ͼƬ��ʽ
 * 2��ͼƬ��С
 * 3��ͼƬ���������
 * @author Administrator
 *
 */
public class PicUploadUtil {
	//�п�
	public static boolean isEmpty(MultipartFile file){
		if(file.getSize()<=0){
			return false;
		}
		return true; 
	}

	//1��ͼƬ��ʽ  �������false���ʾͼƬ��ʽ����  
	public static boolean picType(MultipartFile file,String backNames){
		String originalName=file.getOriginalFilename();
		String backName=originalName.substring(originalName.lastIndexOf(".")+1);
		String[] names=backNames.split(",");
		for(int i=0;i<names.length;i++){
			if(backName.equals(names[i])){
				return true;
			}
		}
		return false;
	}
	
	//2��ͼƬ��С   ���ܳ���1MB  �������false���ʾͼƬ��С����1MB
	public static boolean picSize(MultipartFile file,long picSize){
		long size=file.getSize();
		//ҳ�洫����ͼƬ��С��B   ��Ҫת��ΪMB	Math.round(imgSize/1024*100/1024) С��1MB
		if(Math.round(size/1024*100/1024)/100>picSize){//B תΪMB
			return false;
		}
		return true;
	}
	
	//3��ͼƬ���������    ��ǰʱ��������գ�ʱ����+һ����λ�����
	public static String createName(MultipartFile file){
		String originalName=file.getOriginalFilename();
		String backName=originalName.substring(originalName.lastIndexOf("."));
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String str=sdf.format(d);
		long math=Math.round(Math.random()*1000);
		String picName=str+math+backName;
		return picName;
	}
	
}
