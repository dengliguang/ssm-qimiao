package com.qimiao.dao;

import org.apache.ibatis.annotations.Param;

import com.qimiao.bean.CustMsg;

/**
 * 客户留言Dao
 * @author Administrator
 *
 */
public interface CustMsgDao {
	//保存客户留言
	public boolean addCustMsg(@Param("custMsg") CustMsg custMsg);
}
