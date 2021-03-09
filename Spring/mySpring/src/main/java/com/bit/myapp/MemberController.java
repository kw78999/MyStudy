package com.bit.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.myapp.dto.MemberDto;

@Controller
public class MemberController {
	
	@RequestMapping(value = "member/loginForm")
	//     views/member/loginForm.jsp �� ȣ���Ѵ�.
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping("member/confirmId")
	public String confirmId(HttpServletRequest req,Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		model.addAttribute("id",id);
		model.addAttribute("pwd",pwd);
		return "member/confirmId";  //views/member/confirmId.jsp ȣ��
	}
	
	@RequestMapping("member/confirmId1")
	public String confirmId1(@RequestParam("id")String id,
			@RequestParam("pwd")String pwd,Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pwd",pwd);
		return "member/confirmId";  //views/member/confirmId.jsp ȣ��
	}
	
	@RequestMapping(value = "member/joinForm")
	//     views/member/joinForm.jsp �� ȣ���Ѵ�.
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping("member/join")
	public String join(@RequestParam("id")String id,
			@RequestParam("pwd")String pwd,
			@RequestParam("name")String name,
			@RequestParam("email")String email,Model model) {
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setEmail(email);
		model.addAttribute("member",dto);
		
		return "member/join";
	}
	
	/*1. JSP���� �Է��� 4���� ������ MemberDto ��ü�����ϰ� setter ȣ��
	 * 2.model.addAttribute("member",member)
	 */
	@RequestMapping("member/join1")
	public String join1(@ModelAttribute("member")MemberDto member) {
		return "member/join";
	}
	
	//member/student/aaa/9123033
	@RequestMapping("member/student/{studentId}/{num}")
	public String student(@PathVariable String studentId,
			@PathVariable int num,Model model) {
		model.addAttribute("studentId",studentId);
		model.addAttribute("num",num);
		return "member/student"; //member/student.jsp ����
	}
	
	
}