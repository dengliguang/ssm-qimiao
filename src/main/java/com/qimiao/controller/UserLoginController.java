package com.qimiao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qimiao.bean.User;
import com.qimiao.service.UserLoginService;
import com.qimiao.utils.Msg;
/**
 * 七秒后台登录验证Controller
 * 
 * rest风格的url
 * url=/qimiao/back/{id}    	method=GET      查询
 * url=/qimiao/back/user		method=POST	         保存
 * url=/qimiao/{id}				method=PUT		修改
 * url=/qimiao/{id} 			method=DELETE   删除
 * @author Administrator
 *
 */
@Controller
public class UserLoginController {
	@Autowired
	private UserLoginService userLogin;
	
	//1、登录验证   
	@RequestMapping(value="/background/user",method=RequestMethod.GET)
	@ResponseBody
	public Msg loginUser(
			@ModelAttribute User user,
			HttpSession session
			){
		boolean b=userLogin.UserLogin(user.getUserPhone(), user.getPassword(),session);
		if(!b){
			return Msg.failure().add("error", "账号或者密码错误！");
		}
		/*session.setAttribute("user", user);
		System.out.println(user);*/
		return Msg.success().add("success", "登录成功！");
	}
	
	//2、验证是否已登录   在登录页面如果成功把user存入session 在后台主页面发送ajax请求，判断是否登录了，如果没有直接跳登录页面
	@RequestMapping(value="/islogin",method=RequestMethod.GET)
	@ResponseBody
	public Msg isLogin(
			HttpSession session
			){
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		if(user==null ||user.getUserId()==null){
			return Msg.failure().add("error", "没有登录！");
		}
		Msg m=Msg.success().add("user", user);
		m.add("msg", "已经登录！");
		return m;
	}	
	
	//3、退出登录      根据当前账号的userId,清空session里面的user
	@RequestMapping(value="/exit/login",method=RequestMethod.GET)
	@ResponseBody
	public Msg exitLogin(@RequestParam("userId")Integer userId,
				HttpSession session){
		if(userId==null){
			return Msg.failure().add("msg", "userId为空！");
		}
		session.removeAttribute("user");
		return Msg.success().add("msg", "成功退出！");
	}
}
