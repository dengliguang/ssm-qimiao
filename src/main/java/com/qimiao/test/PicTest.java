package com.qimiao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qimiao.bean.News;
import com.qimiao.dao.EditDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class PicTest {
	@Autowired
	private EditDao epd;
	
	
	
	@Test
	public void test(){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String str=sdf.format(d);
		//System.out.println(str);	
		for(int i=0;i<1000;i++){
			long math=Math.round(Math.random()*1000);
			System.out.println(Math.random()*1000);
		}
	}
	
	@Test
	public void testEditPic(){
		/*Integer count=epd.selectPicCount("http://localhost:8080/bbs/20171026142003555.jpg");
		System.out.println(count);*/
		/*boolean b=epd.deletePic("http://localhost:8080/bbs/20171103103202231.jpg");
		System.out.println(b);*/
		
		boolean b=epd.updatePicTotal(74);
		System.out.println(b);
	}
	
	@Test
	public void testEditNews(){
		boolean b=epd.updateNews(new News(75, "天狮", "公司新闻", "天下无敌", new Date(), 2,1));
		System.out.println(b);
		
	}
}
