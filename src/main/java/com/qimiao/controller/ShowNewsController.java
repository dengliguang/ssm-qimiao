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
 * 展示新闻的Controller
 * @author Administrator
 *
 */
@Controller
public class ShowNewsController {
	@Autowired
	private NewsService newsService;
	
	//查询新闻信息
	@RequestMapping(value="/news/show",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectNews(@RequestParam("pageNum") Integer pageNum){
		System.out.println(pageNum);
		Msg msg=newsService.showNews(pageNum);
		return Msg.success().add("msg", msg);
	}
	
	//根据新闻类型查询新闻信息
	@RequestMapping(value="/news/show/type",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectNewsByType(@RequestParam("pageNum") Integer pageNum,
					@RequestParam("type") String type,
					@RequestParam("tab") String tab){
		Msg msg=newsService.getNewsByType(type, pageNum,tab);
		return Msg.success().add("msg", msg);
	}
	
	//查询新闻内容
	@RequestMapping(value="/news/content",method=RequestMethod.POST)
	@ResponseBody
	public Msg getContentNews(@RequestParam("newsId") Integer newsId){
		ShowNews showNews=newsService.getContentNews(newsId);
		System.out.println(showNews);
		return Msg.success().add("news", showNews);
	}
	
}
