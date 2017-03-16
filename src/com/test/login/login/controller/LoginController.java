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
	 * 登录验证
	 * @param user
	 * @param map
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user,ModelMap map,HttpServletResponse response)throws Exception{
		if(user.getUsername()!=""||user.getUsername()!=null){
			//判断用户的数量
			int count=service.getUserCount(user.getUsername());
			if(count>0){
				//根据用户名查询密码
				int countPass=service.getPassCount(user.getUsername(),user.getPassWord());
				if(countPass>0){
					//跳转到首页
					return new ModelAndView(LoginController.MAIN,map);
				}else{
					return new ModelAndView(LoginController.TESS,map);
				}
			}else{
				return new ModelAndView(LoginController.TESS,map);
			//通过PrintWrite，以流方式输出html，返回给客户端，显示在IE上。
			//response.setContentType("text/html; charset=utf-8"); html
			//.setContentType("text/plain; charset=utf-8"); 文本
			//text/javascript json数据
			//application/xml  xml数据
//			response.setContentType("text/html; charset=gbk");  
//		    PrintWriter out = response.getWriter();   
//		    out.println("<script language='javascript'>");   
//		    out.println("alert('用户名或密码错误');");  
//		    out.print("</script>"); 
//		    out.flush();
//		    out.close();
//				return new ModelAndView(LoginController.TESS,map);
			}
		}
		return new ModelAndView(LoginController.TESS,map);
	}
	/**
	 * 重新登录页面
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(){
		return new ModelAndView(LoginController.TOLOGIN);
	}
	

}
