package com.bit.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@RequestMapping("studentConfirm")
	public String studentRedirect(@RequestParam("id")String id) {
		if(id.equals("aaa"))
			return "redirect:studentOK";
		return "redirect:studentNG";//redirect 중요 다른 액션을 호출
	}
	
	@RequestMapping("studentOK")
	public String studentOK() {return "student/studentOK";}
	
	@RequestMapping("studentNG")
	public String studentNG() {return "student/studentNG";}
	
	@RequestMapping("studentURL")
	public String studentURL() {
		return "redirect:http://localhost/myapp/form.jsp";
	}
}
