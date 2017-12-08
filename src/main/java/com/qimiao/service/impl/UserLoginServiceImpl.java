package com.qimiao.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qimiao.bean.User;
import com.qimiao.dao.UserDao;
import com.qimiao.service.UserLoginService;
/**
 * 用户登录验证接口实现
 * @author Administrator
 *
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean UserLogin(String userPhone, String password,
			HttpSession session) {
		List<User> users=userDao.getUser();
		for(User user:users){
			if(user.getUserPhone().equals(userPhone)&&user.getPassword().equals(password)){
				session.setAttribute("user", user);
				return true;
			}
		}
		return false;
	}

}
