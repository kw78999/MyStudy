package com.bit.springNote2.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.springNote2.dao.IDao;

@Controller
public class NoteController {
	
	/*spring 林涝 @Autowired, @Inject*/
	@Autowired //林涝, 狼档等 按眉 积己 -> servlet-context.xml
	private SqlSession sqlSession;
	
	@RequestMapping("noteForm")
	public String noteForm() {return "noteForm";}
	
	//list
	@RequestMapping("list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
	    return "noteList";
	}
	
	//write
	@RequestMapping("write")
	public String write(
			@RequestParam("writer")String writer,
			@RequestParam("content")String content) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(writer, content);
		return "redirect:list";
	}
	//delete
	@RequestMapping("delete")
	public String delete(
			@RequestParam("id")String id) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(id);
		return "redirect:list";
	}
}








