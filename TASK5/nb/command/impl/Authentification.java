package by.tc.nb.command.impl;

import by.tc.nb.bean.AuthentificationRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.factoty.DAOFactory;

public class Authentification implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Response res = new Response();
		AuthentificationRequest req = new AuthentificationRequest();

		if (request instanceof AuthentificationRequest) {
			req = (AuthentificationRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String login = req.getLogin();
		String pass = req.getPass();
		try {
			DAOFactory.getInstance().getUserDAO().logination(login, pass);
			res.setErrorStatus(false);
			res.setResultMessage("Everythings Great!");
			return res;
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			res.setErrorStatus(true);
			res.setErrorMessage("SOMETHING'S WHERY BAD");
			return res;
		}
	}

}