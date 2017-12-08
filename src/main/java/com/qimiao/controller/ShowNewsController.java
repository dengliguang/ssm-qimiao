package com.qimiao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qimiao.bean.News;
import com.qimiao.bean.ShowNews;
import com.qimiao.service.NewsService;
import com.qimiao.utils.Msg;

/**
 * չʾ���ŵ�Controller
 * @author Administrator
 *
 */
@Controller
public class ShowNewsController {
	@Autowired
	private NewsService newsService;
	
	//��ѯ������Ϣ
	@RequestMapping(value="/news/show",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectNews(@RequestParam("pageNum") Integer pageNum){
		System.out.println(pageNum);
		Msg msg=newsService.showNews(pageNum);
		return Msg.success().add("msg", msg);
	}
	
	//�����������Ͳ�ѯ������Ϣ
	@RequestMapping(value="/news/show/type",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectNewsByType(@RequestParam("pageNum") Integer pageNum,
					@RequestParam("type") String type,
					@RequestParam("tab") String tab){
		Msg msg=newsService.getNewsByType(type, pageNum,tab);
		return Msg.success().add("msg", msg);
	}
	
	//��ѯ��������
	@RequestMapping(value="/news/content",method=RequestMethod.POST)
	@ResponseBody
	public Msg getContentNews(@RequestParam("newsId") Integer newsId){
		ShowNews showNews=newsService.getContentNews(newsId);
		System.out.println(showNews);
		return Msg.success().add("news", showNews);
	}
	
}
