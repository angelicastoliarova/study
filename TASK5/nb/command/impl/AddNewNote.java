package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;

public class AddNewNote implements Command {
	public Response execute(Request request) throws CommandException {

		AddNoteRequest req = new AddNoteRequest();
		Response response = new Response();

		if (request instanceof AddNoteRequest) {
			req = (AddNoteRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}
		
		String note = req.getNote();
		int userID = req.getUserId();

		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();
		
		try {
			nbService.addNote(note, userID);
			response.setErrorStatus(false);
			response.setResultMessage("All OK!");

		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage("Oooops! I think you write an empty notes. Try again!");
			return response;
		}		


		return response;
	}


}
