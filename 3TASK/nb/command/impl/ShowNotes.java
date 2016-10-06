package by.tc.nb.command.impl;

import java.util.List;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class ShowNotes implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Response response = new Response();

		List<Note> notes = NoteBookProvider.getInstance().getNoteBook().getNotes();
		if (notes.isEmpty() != true) {
			response.setErrorStatus(false);
			response.setResultMessage("succes!");
			for (Note is : notes) {
				System.out.println(is.getNote());
			}
		} else {
			response.setErrorStatus(true);
			response.setErrorMessage("You didn\'t wrote any notes yet");
		}

		return response;
	}

}
