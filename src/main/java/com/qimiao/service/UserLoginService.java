package com.qimiao.service;

import javax.servlet.http.HttpSession;

/**
 * 用户登录验证接口
 * @author Administrator
 *
 */
public interface UserLoginService {
	//验证用户名和密码是否正确
	public boolean UserLogin(String userPhone,String password,HttpSession session);
	
}
