package by.tc.st.command.impl;

import by.tc.st.bean.AddQuiRequest;

import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.command.Command;
import by.tc.st.command.exception.CommandException;
import by.tc.st.service.ServiceFactory;
import by.tc.st.service.TestService;
import by.tc.st.service.exception.ServiceException;

public class AddNewQui implements Command { 
	@Override
	public Response execute(Request request) throws CommandException {
		AddQuiRequest req = null;
		
		if(request instanceof AddQuiRequest){
			req = (AddQuiRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		String qui = req.getQui();
		String ans = req.getAnswer();
		String incorrectAns = req.getIncorrectAnswer();
		int sub = req.getSubject();

		TestService service = ServiceFactory.getInstance().getTestService();

		try {
			service.addQui(qui, sub, ans, incorrectAns);
		} catch(ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			return response;
		}

		response.setErrorStatus(false);
		response.setResultMessage("Success!");

		return response;
	}

}

