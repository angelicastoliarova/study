package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNotesByDateRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;

import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class FindNotesByDate implements Command {

	public Response execute(Request request) throws CommandException {

		FindNotesByDateRequest req = null;
		Response response = new Response();

		if (request instanceof FindNotesByDateRequest) {
			req = (FindNotesByDateRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String dateKey = req.getSearchDate();
		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();

		try {
			nbService.findNotesByDate(dateKey, req.getUserId());
		} catch (ServiceException e) {

			e.printStackTrace();
		}

		response.setErrorStatus(false);
		response.setResultMessage("\nSearch by date complete success\n");
		return response;
	}
}