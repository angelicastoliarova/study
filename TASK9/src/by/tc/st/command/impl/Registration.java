package by.tc.st.command.impl;

import by.tc.st.bean.RegistrationRequest;
import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.command.Command;
import by.tc.st.command.exception.CommandException;
import by.tc.st.service.ServiceFactory;
import by.tc.st.service.UserService;
import by.tc.st.service.exception.ServiceException;

public class Registration implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        RegistrationRequest req = null;

        if(request instanceof  RegistrationRequest) {
            req = (RegistrationRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        Response response = new Response();

        String login = req.getLogin();
        String password = req.getPassword();

        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            userService.registration(login, password);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setErrorStatus(false);
        response.setResultMessage("Success!");
        return response;
    }
}