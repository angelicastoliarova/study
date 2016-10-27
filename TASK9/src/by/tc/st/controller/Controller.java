package by.tc.st.controller;

import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.command.Command;
import by.tc.st.command.exception.CommandException;
import by.tc.st.view.CommandNameValidator;

public class Controller {
	private CommandHelper helper = new CommandHelper();

	public Controller(){}

	public Response doRequest(Request request) {
		Response response = null;
		if(request != null && CommandNameValidator.isValid(request.getCommandName())) {

			String commandName = request.getCommandName();
			Command command = helper.getCommand(commandName);

			try {
				response = command.execute(request);
			} catch (CommandException e) {
				response = new Response();
				response.setErrorStatus(true);
				response.setErrorMessage("ERROR!");
			}
			return response;
		} else {
			response = new Response();
			response.setErrorMessage("BAD REQUEST!");
			response.setErrorStatus(true);
			return response;
		}
	}
}