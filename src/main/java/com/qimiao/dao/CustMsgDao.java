package com.qimiao.dao;

import org.apache.ibatis.annotations.Param;

import com.qimiao.bean.CustMsg;

/**
 * �ͻ�����Dao
 * @author Administrator
 *
 */
public interface CustMsgDao {
	//����ͻ�����
	public boolean addCustMsg(@Param("custMsg") CustMsg custMsg);
}
