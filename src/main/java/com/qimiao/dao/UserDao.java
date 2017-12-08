package com.qimiao.dao;

import java.util.List;

import com.qimiao.bean.User;
/**
 * 查询用户表(users_tb)
 * @author Administrator
 *
 */
public interface UserDao {
	public List<User> getUser();
}
