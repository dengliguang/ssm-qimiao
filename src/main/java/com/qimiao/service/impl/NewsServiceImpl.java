package com.qimiao.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;
import com.qimiao.bean.NewsTemp;
import com.qimiao.bean.ShowNews;
import com.qimiao.dao.NewsDao;
import com.qimiao.service.NewsService;
import com.qimiao.utils.DateUtil;
import com.qimiao.utils.Msg;
/**
 * 添加新闻接口实现类 	
 * 疑问：
 * 先插入新闻主表，再插入图片表	
 * 1、事物，怎么生成，怎么用，什么时候/怎么样销毁，怎么知道是不是同一个事物，会报什么异常
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {
	@Value("${picPath}")
	private String picPath;
	
	@Autowired
	private NewsDao newsDao;
	//添加新闻
	@Override
	public Msg addNews(NewsTemp temp) {
		//System.out.println(temp);
		//1、判断新闻标题title是否为空
		if(temp.getTitle()==""){
			return Msg.failure().add("msg", "新闻标题不能为空！");
		}
		//2、去重复 title
		Integer count=newsDao.getCount(temp.getTitle());
		if(count>0){
			return Msg.failure().add("msg", "该标题已经存在！");
		}
		//3、判断新闻内容content是否为空
		/*if(temp.getContent()==null){
			System.out.println("fsdf");
		}*/
		//3、判断图片数量是否为0
		String str=temp.getImgSrc();
		int totalNum;
		String[] imgUrl = null;
		if(str==""){
			totalNum=0;
		}else{
			imgUrl=str.split(",");
			totalNum=imgUrl.length;
		}
		//4、存入数据库
		//4.1 封装News bean,存入新闻表
		News news=new News(temp.getTitle(), temp.getType(), temp.getContent(), new Date(), totalNum,temp.getStatus());
		boolean newsBool=newsDao.addNews(news);
		System.out.println(news.getNewsId());
		//4.2 封装NewsImg bean存入图片表   如果没有上传图片(图片为空),那么不需要保存到图片表
		if(totalNum>0){
			for(int i=0;i<imgUrl.length;i++){
				NewsImg newsImg=new NewsImg(imgUrl[i], news.getNewsId(), (i+1));
				boolean imgBool=newsDao.addNewsImg(newsImg);
				//System.out.println(newsImg);
			}
		}
		return Msg.success().add("msg", "添加成功！");
	}
	
	//查询所有新闻
	@Override
	public Msg showNews(Integer pageNum){
		//创建ShowNews对象，用于页面展示
		List<ShowNews> list=new ArrayList<ShowNews>();
		//分页
		PageHelper.startPage(pageNum, 5);	//当前页     每页显示多少条
		List<News> newsList=newsDao.selectNews();
		System.out.println(newsList);
		PageInfo page=new PageInfo(newsList,5);
		for(News n: newsList){
			ShowNews sn=new ShowNews();
			List<String> imgSrcList=new ArrayList<String>(); 
			//根据查询的n(每一个news对象),查询其子表,获取相对应的图片
			List<NewsImg> newsImgList=newsDao.selectNewsImg(n.getNewsId());
			for(NewsImg newsImg: newsImgList){
				imgSrcList.add(newsImg.getImgSrc());
			}
			//封装ShowNews
			sn.setNewsId(n.getNewsId());
			sn.setTitle(n.getTitle());
			sn.setType(n.getType());
			sn.setContent(n.getContent());
			//把Date转为String
			String time=DateUtil.getTime(n.getTime());
			sn.setTime(time);
			sn.setPicTotal(n.getPicTotal());
			sn.setImgList(imgSrcList);
			sn.setStatus(n.getStatus());
			list.add(sn);
			
		}
		/*for(ShowNews showNews: list){
			System.out.println(showNews);
		}*/
		Msg msg=Msg.success().add("list", list);
		msg.add("pageInfo", page);
		return msg;
	}
	
	//根据newsId查询新闻内容
	@Override
	public ShowNews getContentNews(Integer newsId) {
		News news=newsDao.selectNewsByNewsId(newsId);
		ShowNews showNews=new ShowNews();
		showNews.setTitle(news.getTitle());
		showNews.setType(news.getType());
		//把Date转为String
		Date date=news.getTime();
		String time=DateUtil.getTime(date);
		showNews.setTime(time);
		showNews.setContent(news.getContent());
		showNews.setNewsId(news.getNewsId());
		showNews.setStatus(news.getStatus());
		return showNews;
	}
	//根据新闻类型查询新闻和图片表，封装showNews
	@Override
	public Msg getNewsByType(String newsType, Integer pageNum,String tab) {
		//创建ShowNews对象，用于页面展示
			List<ShowNews> list=new ArrayList<ShowNews>();
			//分页
			if(tab.equals("servicer")){
				PageHelper.startPage(pageNum, 5);	//当前页     每页显示多少条
			}else{
				PageHelper.startPage(pageNum, 3);
			}
			List<News> newsList=newsDao.selectNewsByType(newsType);
			PageInfo page=new PageInfo(newsList,5);
			for(News n: newsList){
				ShowNews sn=new ShowNews();
				List<String> imgSrcList=new ArrayList<String>(); 
				//根据查询的n(每一个news对象),查询其子表,获取相对应的图片
				List<NewsImg> newsImgList=newsDao.selectNewsImg(n.getNewsId());
				for(NewsImg newsImg: newsImgList){
					imgSrcList.add(newsImg.getImgSrc());
				}
				//封装ShowNews
				sn.setNewsId(n.getNewsId());
				sn.setTitle(n.getTitle());
				sn.setType(n.getType());
				sn.setContent(n.getContent());
				//把Date转为String
				String time=DateUtil.getTime(n.getTime());
				sn.setTime(time);
				sn.setPicTotal(n.getPicTotal());
				sn.setImgList(imgSrcList);
				sn.setStatus(n.getStatus());
				list.add(sn);
				
			}
			/*for(ShowNews showNews: list){
				System.out.println(showNews);
			}*/
			Msg msg=Msg.success().add("list", list);
			msg.add("pageInfo", page);
			return msg;	
	}
	//根据新闻Id查询新闻和图片表，封装showNews
	@Override
	public ShowNews getNewsByNewsId(Integer newsId) {
		List<String> imgList=new ArrayList<String>();
		//根据newsId查询新闻表
		News news=newsDao.selectNewsByNewsId(newsId);
		//根据newsId查询图片表
		List<NewsImg> newsImgList=newsDao.selectNewsImg(newsId);
		if(news.getPicTotal()>0){
			for(NewsImg newsImg:newsImgList){
				String imgSrc=newsImg.getImgSrc();
				imgList.add(imgSrc);
			}
		}
		System.out.println(imgList);
		ShowNews showNews=new ShowNews();
		showNews.setTitle(news.getTitle());
		showNews.setType(news.getType());
		//把Date转为String
		Date date=news.getTime();
		String time=DateUtil.getTime(date);
		showNews.setTime(time);
		showNews.setContent(news.getContent());
		showNews.setNewsId(news.getNewsId());
		showNews.setPicTotal(news.getPicTotal());
		showNews.setImgList(imgList);
		showNews.setStatus(news.getStatus());
		return showNews;
	}
	
	//根据图片url，删除图片服务器上的图片
	@Override
	public Msg deletePic(String deleteSrc) {
		//根据图片名字，图片服务器路径 在图片服务器上删除该图片
		String picName=deleteSrc.substring(deleteSrc.lastIndexOf("/")+1);	
		File picFile=new File(picPath,picName);
		boolean b=picFile.delete();
		if(b){
			return Msg.success().add("deleteMsg", "删除成功！");
		}
		return Msg.failure().add("deleteMsg", "删除失败!");
	}

}
