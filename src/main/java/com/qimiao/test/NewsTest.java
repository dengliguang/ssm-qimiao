package com.qimiao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;
import com.qimiao.dao.NewsDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class NewsTest {
	@Autowired
	private NewsDao newsDao;
	
	@Test
	public void NewsTest(){
		Integer count=newsDao.getCount(null);
		System.out.println(count);
	}
	
	@Test
	public void NewsAddTest(){
		News news=new News("天ss54522152s","公司新闻","夜雨十年灯",new Date(),2,1);
		boolean count=newsDao.addNews(news);
		System.out.println(count);
		System.out.println(news.toString());
	}
	
	@Test
	public void NewsImgAddTest(){
		NewsImg img=new NewsImg("http://2fsd33sdf", 54, 1);
		boolean b=newsDao.addNewsImg(img);
		System.out.println(b+"---"+img.getImgId());
	}
	
	@Test
	public void ShowNewsTest(){
		PageHelper.startPage(0, 3); 
		List<News> news=newsDao.selectNews();
		for(News n: news){
			System.out.println(n);
		}
	}
	
	@Test
	public void ShowNewsImg(){
		PageHelper.startPage(0, 3); 
		/*List<NewsImg> newsImg=newsDao.selectNewsImg();
		for(NewsImg img: newsImg){
			System.out.println(newsImg);
		}*/
		PageHelper.startPage(0, 3); 
		List<News> news=newsDao.selectNews();
		for(News n: news){
			System.out.println(n);
		}
		/*PageInfo page=new PageInfo(newsImg,7);	
		System.out.println(page);*/
	}
	
	@Test
	public void ContentNewsTest(){
		//News news=newsDao.selectContentNews(65);
		//System.out.println(news.getContent());
	}
	
	@Test
	public void selectNewsByTypeTest(){
		List<News> news=newsDao.selectNewsByType("行业资讯");
		for(News n:news){
			System.out.println(n);
		}
		
	}
}	





