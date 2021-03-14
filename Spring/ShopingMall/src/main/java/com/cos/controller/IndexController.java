package com.cos.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cos.domain.MemberVO;
import com.cos.service.MemberService;

@Controller
public class IndexController {

	
	
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	
}
