package com.bit.springBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.springBoard.command.BoardCommand;
import com.bit.springBoard.command.BoardContentCommand;
import com.bit.springBoard.command.BoardDeleteCommand;
import com.bit.springBoard.command.BoardListCommand;
import com.bit.springBoard.command.BoardModifyCommand;
import com.bit.springBoard.command.BoardWriteCommand;

@Controller
public class BoardController {

	BoardCommand command;
	
	@RequestMapping("writeView")
	public String writeView() {return "writeView";}
	
	@RequestMapping("write")
	public String write(HttpServletRequest req,Model model) {
		model.addAttribute("request",req);
		command = new BoardWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new BoardListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("contentView")
	public String contentView(HttpServletRequest req,Model model) {
		model.addAttribute("request",req);
		command = new BoardContentCommand();
		command.execute(model);
		return "contentView";
	}
	
	//수정은 포스트만 허용
	@RequestMapping(value="modify",method = RequestMethod.POST)
	public String modify(HttpServletRequest req,Model model) {
		model.addAttribute("request",req);
		command = new BoardModifyCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest req,Model model) {
		model.addAttribute("request",req);
		command = new BoardDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	
}
