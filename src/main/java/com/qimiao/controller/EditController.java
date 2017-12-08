package com.qimiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qimiao.bean.NewsTemp;
import com.qimiao.bean.ShowNews;
import com.qimiao.service.EditService;
import com.qimiao.service.NewsService;
import com.qimiao.utils.Msg;

/**
 * �༭ͼƬ��Controller 
 * ������ɾ�������� 
 * @author Administrator
 *
 */
@Controller
public class EditController {
	@Autowired
	private EditService pes;
	
	@Autowired
	private NewsService newsService;
	
	//1������newsId��ѯshowNews  ���ڱ༭ҳ����� 
	@RequestMapping(value="/news/edit",method=RequestMethod.POST)
	@ResponseBody 
	public Msg getNewsById(@RequestParam("newsId") Integer newsId ){
		ShowNews showNews=newsService.getNewsByNewsId(newsId);
		return Msg.success().add("showNews", showNews);
	}
	
	//ɾ��ͼƬ ������ɾ��ͼƬ�������ϵ�ͼƬ	 ������ݿ� �������ͼƬurl
	@RequestMapping(value="/pic/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg deletePic(@RequestParam("deleteSrc") String deleteSrc,
					@RequestParam("newsId") Integer newsId){
		boolean b=pes.deletePic(deleteSrc,newsId);
		if(!b){
			return Msg.failure().add("deleteMsg", "ͼƬ�����ڣ�ɾ��ʧ�ܣ�");
		}
		return Msg.success().add("deleteMsg", "ɾ���ɹ���");
	}
	
	//����������Ϣ
	@RequestMapping(value="/news/update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateEditNews(NewsTemp newsTemp){
		System.out.println(newsTemp);
		Msg msg=pes.update(newsTemp);
		return msg;      
	}
	
}
