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
 * ������Žӿ�ʵ���� 	
 * ���ʣ�
 * �Ȳ������������ٲ���ͼƬ��	
 * 1�������ô���ɣ���ô�ã�ʲôʱ��/��ô�����٣���ô֪���ǲ���ͬһ������ᱨʲô�쳣
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {
	@Value("${picPath}")
	private String picPath;
	
	@Autowired
	private NewsDao newsDao;
	//�������
	@Override
	public Msg addNews(NewsTemp temp) {
		//System.out.println(temp);
		//1���ж����ű���title�Ƿ�Ϊ��
		if(temp.getTitle()==""){
			return Msg.failure().add("msg", "���ű��ⲻ��Ϊ�գ�");
		}
		//2��ȥ�ظ� title
		Integer count=newsDao.getCount(temp.getTitle());
		if(count>0){
			return Msg.failure().add("msg", "�ñ����Ѿ����ڣ�");
		}
		//3���ж���������content�Ƿ�Ϊ��
		/*if(temp.getContent()==null){
			System.out.println("fsdf");
		}*/
		//3���ж�ͼƬ�����Ƿ�Ϊ0
		String str=temp.getImgSrc();
		int totalNum;
		String[] imgUrl = null;
		if(str==""){
			totalNum=0;
		}else{
			imgUrl=str.split(",");
			totalNum=imgUrl.length;
		}
		//4���������ݿ�
		//4.1 ��װNews bean,�������ű�
		News news=new News(temp.getTitle(), temp.getType(), temp.getContent(), new Date(), totalNum,temp.getStatus());
		boolean newsBool=newsDao.addNews(news);
		System.out.println(news.getNewsId());
		//4.2 ��װNewsImg bean����ͼƬ��   ���û���ϴ�ͼƬ(ͼƬΪ��),��ô����Ҫ���浽ͼƬ��
		if(totalNum>0){
			for(int i=0;i<imgUrl.length;i++){
				NewsImg newsImg=new NewsImg(imgUrl[i], news.getNewsId(), (i+1));
				boolean imgBool=newsDao.addNewsImg(newsImg);
				//System.out.println(newsImg);
			}
		}
		return Msg.success().add("msg", "��ӳɹ���");
	}
	
	//��ѯ��������
	@Override
	public Msg showNews(Integer pageNum){
		//����ShowNews��������ҳ��չʾ
		List<ShowNews> list=new ArrayList<ShowNews>();
		//��ҳ
		PageHelper.startPage(pageNum, 5);	//��ǰҳ     ÿҳ��ʾ������
		List<News> newsList=newsDao.selectNews();
		System.out.println(newsList);
		PageInfo page=new PageInfo(newsList,5);
		for(News n: newsList){
			ShowNews sn=new ShowNews();
			List<String> imgSrcList=new ArrayList<String>(); 
			//���ݲ�ѯ��n(ÿһ��news����),��ѯ���ӱ�,��ȡ���Ӧ��ͼƬ
			List<NewsImg> newsImgList=newsDao.selectNewsImg(n.getNewsId());
			for(NewsImg newsImg: newsImgList){
				imgSrcList.add(newsImg.getImgSrc());
			}
			//��װShowNews
			sn.setNewsId(n.getNewsId());
			sn.setTitle(n.getTitle());
			sn.setType(n.getType());
			sn.setContent(n.getContent());
			//��DateתΪString
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
	
	//����newsId��ѯ��������
	@Override
	public ShowNews getContentNews(Integer newsId) {
		News news=newsDao.selectNewsByNewsId(newsId);
		ShowNews showNews=new ShowNews();
		showNews.setTitle(news.getTitle());
		showNews.setType(news.getType());
		//��DateתΪString
		Date date=news.getTime();
		String time=DateUtil.getTime(date);
		showNews.setTime(time);
		showNews.setContent(news.getContent());
		showNews.setNewsId(news.getNewsId());
		showNews.setStatus(news.getStatus());
		return showNews;
	}
	//�����������Ͳ�ѯ���ź�ͼƬ����װshowNews
	@Override
	public Msg getNewsByType(String newsType, Integer pageNum,String tab) {
		//����ShowNews��������ҳ��չʾ
			List<ShowNews> list=new ArrayList<ShowNews>();
			//��ҳ
			if(tab.equals("servicer")){
				PageHelper.startPage(pageNum, 5);	//��ǰҳ     ÿҳ��ʾ������
			}else{
				PageHelper.startPage(pageNum, 3);
			}
			List<News> newsList=newsDao.selectNewsByType(newsType);
			PageInfo page=new PageInfo(newsList,5);
			for(News n: newsList){
				ShowNews sn=new ShowNews();
				List<String> imgSrcList=new ArrayList<String>(); 
				//���ݲ�ѯ��n(ÿһ��news����),��ѯ���ӱ�,��ȡ���Ӧ��ͼƬ
				List<NewsImg> newsImgList=newsDao.selectNewsImg(n.getNewsId());
				for(NewsImg newsImg: newsImgList){
					imgSrcList.add(newsImg.getImgSrc());
				}
				//��װShowNews
				sn.setNewsId(n.getNewsId());
				sn.setTitle(n.getTitle());
				sn.setType(n.getType());
				sn.setContent(n.getContent());
				//��DateתΪString
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
	//��������Id��ѯ���ź�ͼƬ����װshowNews
	@Override
	public ShowNews getNewsByNewsId(Integer newsId) {
		List<String> imgList=new ArrayList<String>();
		//����newsId��ѯ���ű�
		News news=newsDao.selectNewsByNewsId(newsId);
		//����newsId��ѯͼƬ��
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
		//��DateתΪString
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
	
	//����ͼƬurl��ɾ��ͼƬ�������ϵ�ͼƬ
	@Override
	public Msg deletePic(String deleteSrc) {
		//����ͼƬ���֣�ͼƬ������·�� ��ͼƬ��������ɾ����ͼƬ
		String picName=deleteSrc.substring(deleteSrc.lastIndexOf("/")+1);	
		File picFile=new File(picPath,picName);
		boolean b=picFile.delete();
		if(b){
			return Msg.success().add("deleteMsg", "ɾ���ɹ���");
		}
		return Msg.failure().add("deleteMsg", "ɾ��ʧ��!");
	}

}
