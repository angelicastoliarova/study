package by.tc.st.command.impl;

import by.tc.st.bean.AddQuiRequest;
import by.tc.st.bean.AddTestRequest;
import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.command.Command;
import by.tc.st.command.exception.CommandException;
import by.tc.st.service.ServiceFactory;
import by.tc.st.service.TestService;
import by.tc.st.service.exception.ServiceException;

public class FormNewTest implements Command {
	@Override
	public Response execute(Request request) throws CommandException {
		AddTestRequest req = null;
		
		if(request instanceof AddTestRequest){
			req = (AddTestRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		String qui = req.getQui();
		int sub = req.getSubject();
		int numberOfTest= req.getnumberTest();
		int quantityOfTests= req.getquantityOfTests();

		TestService service = ServiceFactory.getInstance().getTestService();

		try {
			service.addTest(sub, numberOfTest, quantityOfTests);
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



