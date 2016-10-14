package by.tc.nb.command.impl;

import by.tc.nb.bean.RegistrationRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.factoty.DAOFactory;

public class Registration implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Response res = new Response();
		RegistrationRequest req = new RegistrationRequest();

		if (request instanceof RegistrationRequest) {
			req = (RegistrationRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String login = req.getLogin();
		String pass = req.getPass();

		try {
			if (DAOFactory.getInstance().getUserDAO().registration(login, pass)) {
				res.setErrorStatus(false);
				res.setResultMessage("Everythings Great!");
				return res;
			} else {
				res.setErrorStatus(true);
				res.setErrorMessage("User is not register yet");
				return res;
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			res.setErrorStatus(true);
			res.setErrorMessage("SOMETHING'S WHERY BAD");
			return res;
		}
		

	}

}