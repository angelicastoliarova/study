package by.tc.st;

import org.testng.annotations.Test;
import org.testng.Assert;

import by.tc.st.bean.AddQuiRequest;
import by.tc.st.bean.Response;
import by.tc.st.controller.Controller;
import by.tc.st.dao.DAOFactory;
import by.tc.st.dao.exception.DAOException;

public class AddNewQui {

	
	@Test(dataProvider = "addNewQui", dataProviderClass = DataProvider.class)
	public void Test(int subjectId, String question, String answer, String CommandName) throws DAOException {

		
		DAOFactory.getInstance().getTestDAO();
		
		Response response = new Response();
		Controller controller = new Controller();
		AddQuiRequest request = new AddQuiRequest();
		request.setAnswer(answer);
		request.setQui(question);
		request.setSubject(subjectId);
		request.setCommandName(CommandName);
		response = controller.doRequest(request);
 
	
		Assert.assertEquals(response.isErrorStatus(), false);
	}
}
