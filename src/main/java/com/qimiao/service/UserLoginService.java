package com.qimiao.service;

import javax.servlet.http.HttpSession;

/**
 * �û���¼��֤�ӿ�
 * @author Administrator
 *
 */
public interface UserLoginService {
	//��֤�û����������Ƿ���ȷ
	public boolean UserLogin(String userPhone,String password,HttpSession session);
	
}
