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
		//1������ͼƬurlɾ��ͼƬ�����ͼƬ
		boolean bool=editPicDao.deletePic(deleteSrc);
		if(bool){
			//2��ͼƬ����ɾ���ɹ�ͬʱ����newsId����news����ͼƬ����
			editPicDao.updatePicTotal(newsId);
		}
		// http://localhost:8080/bbs/20171103093514484.jpg
		//����ͼƬ���֣�ͼƬ������·�� ��ͼƬ��������ɾ����ͼƬ
		String picName=deleteSrc.substring(deleteSrc.lastIndexOf("/")+1);	
		File picFile=new File("F:\\tomcat8servers\\img\\",picName);
		boolean b=picFile.delete();
		return b;
	}
	
	//�������ݱ�news��ͼƬ��
	@Override
	public Msg update(NewsTemp temp) {
		//1���ж����ű���title�Ƿ�Ϊ��
				if(temp.getTitle()==""){
					return Msg.failure().add("msg", "���ű��ⲻ��Ϊ�գ�");
				}
				/*//2��ȥ�ظ� title
				Integer count=newsDao.getCount(temp.getTitle());
				if(count>0){
					return Msg.failure().add("msg", "�ñ����Ѿ����ڣ�");
				}*/
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
				News news=new News(temp.getNewsId(),temp.getTitle(), temp.getType(), temp.getContent(), new Date(), totalNum,temp.getStatus());
				boolean newsBool=editPicDao.updateNews(news);
				if(newsBool){
					//4.2 ����newsId��ɾ��ͼƬ�����newsId���������ݣ����������
					boolean b=editPicDao.deleteImg(news.getNewsId());
					//4.2 ��װNewsImg bean����ͼƬ��   ���û���ϴ�ͼƬ(ͼƬΪ��),��ô����Ҫ���浽ͼƬ��
					if(totalNum>0){
						for(int i=0;i<imgUrl.length;i++){
							NewsImg newsImg=new NewsImg(imgUrl[i], news.getNewsId(), (i+1));
							boolean imgBool=editPicDao.updateImgTb(newsImg);
						}
					}
					return Msg.success().add("editMsg", "��ӳɹ���");
				}
				
				return Msg.failure().add("editMsg", "���ʧ��");
	}

}
