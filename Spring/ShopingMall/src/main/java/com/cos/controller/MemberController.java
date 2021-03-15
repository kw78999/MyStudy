package com.cos.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.domain.MemberVO;
import com.cos.service.MemberService;

@Controller
public class MemberController {
	private final static Logger logger = Logger.getGlobal();
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		return "login/join";
	}
	@ResponseBody
	@RequestMapping(value="idCheck",method=RequestMethod.GET)
	public int idCheck(@RequestParam("id")String id) throws Exception {
		int cnt = memberService.idCheck(id);
		return cnt; 
	}
	@RequestMapping(value = "newJoin", method = RequestMethod.POST)
	public String newJoin(MemberVO member,Model model) throws Exception{
		memberService.insert(member);
		model.addAttribute("msg","회원가입 성공");
		model.addAttribute("url","login");
		
		return "redirectJsp";
	}
	@RequestMapping(value = "/newLogin", method = RequestMethod.POST)
	public String newLogin(MemberVO member, 
			HttpServletRequest req) throws Exception{
		int cnt = memberService.login(member);
		if(cnt==1) {
			HttpSession session = req.getSession();
			session.setAttribute("id", member.getId());
			
		}
		return "redirect:index";
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String userLogout(HttpServletRequest req,Model model) throws IOException {
		req.getSession().invalidate();
		
		model.addAttribute("msg","로그아웃 되었습니다.");
		model.addAttribute("url","index");
		
		return "redirectJsp";
	}
	
}
