package com.cos.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cos.domain.UserVO;
import com.cos.service.CategoryService;
import com.cos.service.UserService;

@Controller
public class UserController {

	@Inject
	private CategoryService ctService;
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/userLoginForm", method = RequestMethod.GET)
	public String userLoginForm(Model model) throws Exception{
		model.addAttribute("ctg1", ctService.selectGubun1(1));
		model.addAttribute("ctg2", ctService.selectGubun1(2));
		model.addAttribute("ctg3", ctService.selectGubun1(3));
		model.addAttribute("ctg4", ctService.selectGubun1(4));
		return "user/userLoginForm";
	}
	
	@RequestMapping(value = "/userJoinForm", method = RequestMethod.GET)
	public String userJoinForm(Model model, Locale locale) throws Exception{
		model.addAttribute("ctg1", ctService.selectGubun1(1));
		model.addAttribute("ctg2", ctService.selectGubun1(2));
		model.addAttribute("ctg3", ctService.selectGubun1(3));
		model.addAttribute("ctg4", ctService.selectGubun1(4));
		return "user/userJoinForm";
	}
	
	@RequestMapping(value = "/userJoin", method = RequestMethod.POST)
	public String userJoin(UserVO user) throws Exception{
		userService.insert(user);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(UserVO user, 
			HttpServletRequest req) throws Exception{
		int cnt = userService.login(user);
		if(cnt==1) {
			HttpSession session = req.getSession();
			user = userService.select(user.getUserID());
			session.setAttribute("userID", user.getUserID());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userEmail", user.getUserEmail());
		}
		return "redirect:index";
	}
	
	@RequestMapping(value = "/userLogout", method = RequestMethod.GET)
	public String userLogout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:index";
	}

}





