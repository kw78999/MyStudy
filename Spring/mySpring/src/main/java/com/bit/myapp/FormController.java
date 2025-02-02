package com.bit.myapp;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public String list(HttpServletRequest req,Model model){
		//req.setCharacterEncoding("UTF-8"); //post방식 한글처리
		String name = req.getParameter("name");
		model.addAttribute("name",name);
		
		return "list"; //views/list.jsp 호출한다 -> 저장 -> server restart
	}
	
}
