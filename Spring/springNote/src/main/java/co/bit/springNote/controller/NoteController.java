package co.bit.springNote.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.bit.springNote.command.NoteCommand;
import co.bit.springNote.command.NoteDeleteCommand;
import co.bit.springNote.command.NoteListCommand;
import co.bit.springNote.command.NoteWriteCommand;

@Controller
public class NoteController {

	NoteCommand command;
	
	@RequestMapping("noteForm")
	public String noteForm() {return "noteForm";}
	
	//list
	@RequestMapping("list")
	public String list(Model model) {
		command = new NoteListCommand();
		command.execute(model);
		return "noteList";  //noteList.jsp
	}
	
	//write
	@RequestMapping("write")
	public String write(HttpServletRequest req,Model model) {
		model.addAttribute("request",req);
		command = new NoteWriteCommand();
		command.execute(model);
		return "redirect:list"; //noteList.jsp
	}
	
	//delete
	@RequestMapping("delete")
	public String delete(HttpServletRequest req,Model model) {
		model.addAttribute("request",req);
		command = new NoteDeleteCommand();
		command.execute(model);
		return "redirect:list"; //noteList.jsp
	}
}
