package co.bit.springNote.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import co.bit.springNote.dao.NoteDao;

public class NoteDeleteCommand implements NoteCommand {

	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("request");
		
		
		String id = req.getParameter("id");
		
		NoteDao dao = new NoteDao();
		dao.delete(id);

	}

}
