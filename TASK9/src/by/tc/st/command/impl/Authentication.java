package by.tc.st.command.impl;

import by.tc.st.bean.AuthenticationRequest;
import by.tc.st.bean.AuthenticationResponse;
import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.bean.entity.User;
import by.tc.st.command.Command;
import by.tc.st.command.exception.CommandException;
import by.tc.st.service.ServiceFactory;
import by.tc.st.service.UserService;
import by.tc.st.service.exception.ServiceException;

public class Authentication implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        AuthenticationRequest req = null;

        if(request instanceof AuthenticationRequest) {
            req = (AuthenticationRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        AuthenticationResponse response = new AuthenticationResponse();

        String login = req.getLogin();
        String password = req.getPassword();

        UserService userService = ServiceFactory.getInstance().getUserService();

        User currentUser = null;

        try {
            currentUser = userService.logination(login, password);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        if(currentUser == null) {
            response.setErrorStatus(true);
            response.setErrorMessage("Authentication error, user does not exist!");
            return response;
        } else {
            response.setErrorStatus(false);
            response.setResultMessage("Success");
            response.setUser(currentUser);
            return response;
        }
    }
}