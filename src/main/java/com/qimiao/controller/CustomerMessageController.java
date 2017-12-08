package com.qimiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qimiao.bean.CustMsg;
import com.qimiao.service.CustMsgService;
import com.qimiao.utils.Msg;

/**
 * øÕªß¡Ù—‘Controller
 * @author Administrator
 *
 */
@Controller
public class CustomerMessageController {
	@Autowired
	private CustMsgService custMsgService;
	
	@RequestMapping(value="/customer/message", method=RequestMethod.POST)
	@ResponseBody
	public Msg addCustMsg(CustMsg custMsg){
		Msg msg=custMsgService.addCustMsg(custMsg);
		return msg;
	}
}
