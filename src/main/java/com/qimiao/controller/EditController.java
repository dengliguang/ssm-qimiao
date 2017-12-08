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
 * 编辑图片的Controller 
 * 包括：删除，回显 
 * @author Administrator
 *
 */
@Controller
public class EditController {
	@Autowired
	private EditService pes;
	
	@Autowired
	private NewsService newsService;
	
	//1、根据newsId查询showNews  用于编辑页面回显 
	@RequestMapping(value="/news/edit",method=RequestMethod.POST)
	@ResponseBody 
	public Msg getNewsById(@RequestParam("newsId") Integer newsId ){
		ShowNews showNews=newsService.getNewsByNewsId(newsId);
		return Msg.success().add("showNews", showNews);
	}
	
	//删除图片 包括：删除图片服务器上的图片	 清空数据库 表里面的图片url
	@RequestMapping(value="/pic/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg deletePic(@RequestParam("deleteSrc") String deleteSrc,
					@RequestParam("newsId") Integer newsId){
		boolean b=pes.deletePic(deleteSrc,newsId);
		if(!b){
			return Msg.failure().add("deleteMsg", "图片不存在，删除失败！");
		}
		return Msg.success().add("deleteMsg", "删除成功！");
	}
	
	//更新新闻信息
	@RequestMapping(value="/news/update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateEditNews(NewsTemp newsTemp){
		System.out.println(newsTemp);
		Msg msg=pes.update(newsTemp);
		return msg;      
	}
	
}
