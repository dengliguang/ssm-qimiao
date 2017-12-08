package com.qimiao.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qimiao.bean.News;
import com.qimiao.bean.NewsImg;
import com.qimiao.bean.NewsTemp;
import com.qimiao.dao.EditDao;
import com.qimiao.dao.NewsDao;
import com.qimiao.service.EditService;
import com.qimiao.utils.Msg;
@Service
public class EditServiceImpl implements EditService{
	@Value("${picPath}")
	private String picPath;
	
	@Autowired
	private EditDao editPicDao;
	
	@Override
	public boolean deletePic(String deleteSrc,Integer newsId) {
		//1、根据图片url删除图片表里该图片
		boolean bool=editPicDao.deletePic(deleteSrc);
		if(bool){
			//2、图片表里删除成功同时根据newsId更新news表里图片总数
			editPicDao.updatePicTotal(newsId);
		}
		// http://localhost:8080/bbs/20171103093514484.jpg
		//根据图片名字，图片服务器路径 在图片服务器上删除该图片
		String picName=deleteSrc.substring(deleteSrc.lastIndexOf("/")+1);	
		File picFile=new File("F:\\tomcat8servers\\img\\",picName);
		boolean b=picFile.delete();
		return b;
	}
	
	//更新数据表：news表、图片表
	@Override
	public Msg update(NewsTemp temp) {
		//1、判断新闻标题title是否为空
				if(temp.getTitle()==""){
					return Msg.failure().add("msg", "新闻标题不能为空！");
				}
				/*//2、去重复 title
				Integer count=newsDao.getCount(temp.getTitle());
				if(count>0){
					return Msg.failure().add("msg", "该标题已经存在！");
				}*/
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
				//4、更新数据库 
				//4.1 封装News bean,存入新闻表        
				News news=new News(temp.getNewsId(),temp.getTitle(), temp.getType(), temp.getContent(), new Date(), totalNum,temp.getStatus());
				boolean newsBool=editPicDao.updateNews(news);
				if(newsBool){
					//4.2 根据newsId先删除图片表里，该newsId的所有数据，再重新添加
					boolean b=editPicDao.deleteImg(news.getNewsId());
					//4.2 封装NewsImg bean存入图片表   如果没有上传图片(图片为空),那么不需要保存到图片表
					if(totalNum>0){
						for(int i=0;i<imgUrl.length;i++){
							NewsImg newsImg=new NewsImg(imgUrl[i], news.getNewsId(), (i+1));
							boolean imgBool=editPicDao.updateImgTb(newsImg);
						}
					}
					return Msg.success().add("editMsg", "添加成功！");
				}
				
				return Msg.failure().add("editMsg", "添加失败");
	}

}
