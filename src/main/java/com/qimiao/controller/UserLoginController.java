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
 * �����̨��¼��֤Controller
 * 
 * rest����url
 * url=/qimiao/back/{id}    	method=GET      ��ѯ
 * url=/qimiao/back/user		method=POST	         ����
 * url=/qimiao/{id}				method=PUT		�޸�
 * url=/qimiao/{id} 			method=DELETE   ɾ��
 * @author Administrator
 *
 */
@Controller
public class UserLoginController {
	@Autowired
	private UserLoginService userLogin;
	
	//1����¼��֤   
	@RequestMapping(value="/background/user",method=RequestMethod.GET)
	@ResponseBody
	public Msg loginUser(
			@ModelAttribute User user,
			HttpSession session
			){
		boolean b=userLogin.UserLogin(user.getUserPhone(), user.getPassword(),session);
		if(!b){
			return Msg.failure().add("error", "�˺Ż����������");
		}
		/*session.setAttribute("user", user);
		System.out.println(user);*/
		return Msg.success().add("success", "��¼�ɹ���");
	}
	
	//2����֤�Ƿ��ѵ�¼   �ڵ�¼ҳ������ɹ���user����session �ں�̨��ҳ�淢��ajax�����ж��Ƿ��¼�ˣ����û��ֱ������¼ҳ��
	@RequestMapping(value="/islogin",method=RequestMethod.GET)
	@ResponseBody
	public Msg isLogin(
			HttpSession session
			){
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		if(user==null ||user.getUserId()==null){
			return Msg.failure().add("error", "û�е�¼��");
		}
		Msg m=Msg.success().add("user", user);
		m.add("msg", "�Ѿ���¼��");
		return m;
	}	
	
	//3���˳���¼      ���ݵ�ǰ�˺ŵ�userId,���session�����user
	@RequestMapping(value="/exit/login",method=RequestMethod.GET)
	@ResponseBody
	public Msg exitLogin(@RequestParam("userId")Integer userId,
				HttpSession session){
		if(userId==null){
			return Msg.failure().add("msg", "userIdΪ�գ�");
		}
		session.removeAttribute("user");
		return Msg.success().add("msg", "�ɹ��˳���");
	}
}
