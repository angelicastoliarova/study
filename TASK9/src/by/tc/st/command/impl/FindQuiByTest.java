package by.tc.st.command.impl;

import java.util.List;

import by.tc.st.bean.FindTestRequest;
import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.bean.ShowTestResponse;
import by.tc.st.bean.entity.Qui;
import by.tc.st.command.Command;
import by.tc.st.command.exception.CommandException;
import by.tc.st.service.ServiceFactory;
import by.tc.st.service.TestService;
import by.tc.st.service.exception.ServiceException;

public class FindQuiByTest implements Command{

	 @Override
	    public Response execute(Request request) throws CommandException {
	        FindTestRequest req = null;

	        if(request instanceof FindTestRequest) {
	            req = (FindTestRequest) request;
	        } else {
	            throw new CommandException("Wrong command");
	        }

	        ShowTestResponse response = new ShowTestResponse();
	       // String content = req.getContent();

	        List<Qui> result = null;
	        TestService testService = ServiceFactory.getInstance().getTestService();

	        try {
	            result = testService.findQuiByTest(req.getTestId());
	        } catch (ServiceException e) {
	            response.setErrorStatus(true);
	            response.setErrorMessage(e.getMessage());
	            return response;
	        }

	        response.setNotes(result);
	        response.setErrorStatus(false);
	        response.setResultMessage("Success!");

	        return response;
	    }
}
