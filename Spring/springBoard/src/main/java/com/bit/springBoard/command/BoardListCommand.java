package com.bit.springBoard.command;

import org.springframework.ui.Model;

import com.bit.springBoard.dao.BoardDao;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		BoardDao dao = new BoardDao();
		model.addAttribute("list",dao.list());
		
		
	}

}
