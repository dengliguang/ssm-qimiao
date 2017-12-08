package com.qimiao.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qimiao.bean.User;
import com.qimiao.dao.UserDao;

/**
 * 测试：
 * 1、测试是否能连接数据库
 * 2、测试user里面的CRUD
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class UserTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void userTest(){
		//System.out.println(userDao);
		List<User> users=userDao.getUser();
		for(User user:users){
			Date date=user.getTime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String d=sdf.format(date);  
			System.out.println(d);
		}
		
	}
}
