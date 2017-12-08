package com.qimiao.controller;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsTemp;
import com.qimiao.service.NewsService;
import com.qimiao.utils.Msg;
/**
 * 添加新闻的Controll
 * @author Administrator
 *
 */
@Controller
public class NewsAddController {
	@Autowired
	private NewsService newsService;
	//添加新闻
	@RequestMapping(value="/news/add",method=RequestMethod.POST)
	@ResponseBody
	public Msg addNewsPage(NewsTemp newsTemp){ 
		System.out.println(newsTemp);
		Msg m=newsService.addNews(newsTemp);
		return m;
	}
	
	//删除图片：根据图片url删除图片服务器上的图片
	@RequestMapping(value="/addPage/pic/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg deletePic(@RequestParam("deleteSrc") String deleteSrc){
		System.out.println(deleteSrc);
		Msg msg=newsService.deletePic(deleteSrc);
		return msg;
	}
}
