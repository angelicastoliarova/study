package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNotesRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

import by.tc.nb.dao.factoty.DAOFactory;


public class FindNotes implements Command {

	public Response execute(Request request) throws CommandException {

		Response response = new Response();
		FindNotesRequest req = new FindNotesRequest();
		if (request instanceof FindNotesRequest) {
			req = (FindNotesRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String keyWord = req.getKeyWords();
		DAOFactory.getInstance().getNoteBookDAO().findNoteByContent(keyWord, req.getUserId());

		response.setErrorStatus(false);
		response.setResultMessage("\nSearch completed success\n");

		return response;
	}
}
