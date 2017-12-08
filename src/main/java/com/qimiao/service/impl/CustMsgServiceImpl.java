package com.qimiao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qimiao.bean.CustMsg;
import com.qimiao.dao.CustMsgDao;
import com.qimiao.service.CustMsgService;
import com.qimiao.utils.Msg;
/**
 * 添加客户留言
 * @author Administrator
 *
 */
@Service
public class CustMsgServiceImpl implements CustMsgService{
	@Autowired
	private CustMsgDao custMsgDao;

	@Override
	public Msg addCustMsg(CustMsg custMsg) {
		custMsg.setTime(new Date());
		System.out.println(custMsg);
		boolean b=custMsgDao.addCustMsg(custMsg);
		if(b){
			return Msg.success().add("custMsg", "添加成功");
		}
		return Msg.failure().add("custMsg", "添加失败");
	}

}
