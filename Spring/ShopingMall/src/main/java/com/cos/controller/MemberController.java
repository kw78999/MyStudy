package com.cos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cos.domain.MemberVO;
import com.cos.service.MemberService;

@Controller
public class MemberController {

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
	@RequestMapping(value = "newJoin", method = RequestMethod.POST)
	public String newJoin(MemberVO member) throws Exception{
		memberService.insert(member);
		
		return "redirect:login";
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
	public String userLogout(HttpServletRequest req,HttpServletResponse res) throws IOException {
		req.getSession().invalidate();
		
		 res.setContentType("text/html; charset=UTF-8");
         PrintWriter out = res.getWriter();
         out.println("<script>alert('로그아웃 되었습니다.'); location.href='index'</script>");
         out.flush();


		return "redirect:index";
	}
	
}
