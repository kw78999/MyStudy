package com.bit.springBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bit.springBoard.dao.BoardDao;

public class BoardContentCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("request");
		int id = Integer.parseInt(req.getParameter("id"));
		BoardDao dao = new BoardDao();
		model.addAttribute("contentView", dao.contentView(id));
	}

}
