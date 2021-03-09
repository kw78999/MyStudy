package co.bit.springNote.command;

import org.springframework.ui.Model;

import co.bit.springNote.dao.NoteDao;

public class NoteListCommand implements NoteCommand {

	@Override
	public void execute(Model model) {
		NoteDao dao = new NoteDao();
		model.addAttribute("list",dao.list());

	}

}
