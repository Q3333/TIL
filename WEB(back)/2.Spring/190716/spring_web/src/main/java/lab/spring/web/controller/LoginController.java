package lab.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.UserVO;
import lab.spring.web.service.UserService;

@Controller("/login.do")
public class LoginController {

	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "loginForm";
	}
	
	//���1 �ϳ��ϳ� Param���� ���� �޴� ���
//	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView login(@RequestParam("userid")String uid,
//							  @RequestParam("userpwd")String upwd) {
//		ModelAndView mav = new ModelAndView();
//		UserVO vo = null;
//		vo = service.login(uid, upwd);
//		mav.addObject("user",vo);
//		if(vo!=null) {
//			mav.setViewName("loginSuccess");
//		}else {
//			mav.setViewName("loginFail");
//		}
//		
//		return mav;
//	}
	
//	���2 ���� ��ü�� �����ͼ� ���� �޴� ���, framework�� �ڵ����� �Ķ���� ���� �´� ��ü�� ��Ī����.
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(UserVO user) {
		ModelAndView mav = new ModelAndView();
		UserVO vo = null;
		vo = service.login(user.getUserid(),user.getUserpwd());
		mav.addObject("user",vo);
		if(vo!=null) {
			mav.setViewName("loginSuccess");
		}else {
			mav.setViewName("loginFail");
		}		
	
		return mav;
	}
	
//	//���3 
//	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse resonse) {
//		
//		ModelAndView mav = new ModelAndView();
//		UserVO user = null;
//		String uid = request.getParameter("userid");
//		String upwd = request.getParameter("userpwd");
//		
//		user = service.login(uid, upwd);
//		mav.addObject("user",user);
//		if(user!=null) {
//			mav.setViewName("loginSuccess");
//		}else {
//			mav.setViewName("loginFail");
//		}		
//	
//		return mav;
//	}
	
}