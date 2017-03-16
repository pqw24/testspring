package com.test.login.login.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.login.login.model.User;
import com.test.login.login.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	public static final String TESS="login/loginError";
	public static final String TOLOGIN="login/login";
	public static final String MAIN="login/main";
	@Autowired
	public UserService service;
	/**
	 * ��¼��֤
	 * @param user
	 * @param map
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user,ModelMap map,HttpServletResponse response)throws Exception{
		if(user.getUsername()!=""||user.getUsername()!=null){
			//�ж��û�������
			int count=service.getUserCount(user.getUsername());
			if(count>0){
				//�����û�����ѯ����
				int countPass=service.getPassCount(user.getUsername(),user.getPassWord());
				if(countPass>0){
					//��ת����ҳ
					return new ModelAndView(LoginController.MAIN,map);
				}else{
					return new ModelAndView(LoginController.TESS,map);
				}
			}else{
				return new ModelAndView(LoginController.TESS,map);
			//ͨ��PrintWrite��������ʽ���html�����ظ��ͻ��ˣ���ʾ��IE�ϡ�
			//response.setContentType("text/html; charset=utf-8"); html
			//.setContentType("text/plain; charset=utf-8"); �ı�
			//text/javascript json����
			//application/xml  xml����
//			response.setContentType("text/html; charset=gbk");  
//		    PrintWriter out = response.getWriter();   
//		    out.println("<script language='javascript'>");   
//		    out.println("alert('�û������������');");  
//		    out.print("</script>"); 
//		    out.flush();
//		    out.close();
//				return new ModelAndView(LoginController.TESS,map);
			}
		}
		return new ModelAndView(LoginController.TESS,map);
	}
	/**
	 * ���µ�¼ҳ��
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(){
		return new ModelAndView(LoginController.TOLOGIN);
	}
	

}
