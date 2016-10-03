package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class ShowNotes implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		return null;
		
	
	}
}