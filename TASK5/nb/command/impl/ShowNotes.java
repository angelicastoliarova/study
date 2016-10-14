package by.tc.nb.command.impl;

import java.util.List;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.bean.entity.SQLUser;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.factoty.DAOFactory;
import by.tc.nb.source.NoteBookProvider;

public class ShowNotes implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Response response = new Response();

		DAOFactory.getInstance().getNoteBookDAO().showAllNotes(SQLUser.getUserID());
		response.setErrorStatus(false);
		response.setResultMessage("The notes is shown great!");
		return response;
	}

}