package co.bit.springNote.command;

import org.springframework.ui.Model;

public interface NoteCommand {

	public void execute(Model model);
}
