package com.bit.springBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bit.springBoard.dao.BoardDao;

public class BoardModifyCommand implements BoardCommand{
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("request");
		String id = req.getParameter("id");
		System.out.println("id ��:"+id);
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		BoardDao dao = new BoardDao();
		dao.modify(id, name, title, content);
	}
}
