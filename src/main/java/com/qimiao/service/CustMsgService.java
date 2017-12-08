package com.qimiao.service;

import com.qimiao.bean.CustMsg;
import com.qimiao.utils.Msg;

/**
 * 客户留言Service
 * @author Administrator
 *
 */
public interface CustMsgService {
	//保存客户留言
	public Msg addCustMsg(CustMsg custMsg);
}
