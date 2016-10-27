package by.tc.st;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.tc.st.bean.AddTestRequest;
import by.tc.st.bean.Response;
import by.tc.st.controller.Controller;

import by.tc.st.dao.exception.DAOException;

public class FormNewTest {
	@Test(dataProvider = "formNewTest", dataProviderClass = DataProvider.class)
	public void myTest(int subjectName, String commandName) throws DAOException {

		Response response = new Response();
		Controller controller = new Controller();
		AddTestRequest request = new AddTestRequest();
		request.setSubject(subjectName);
		request.setCommandName(commandName);
		response = controller.doRequest(request);

		Assert.assertEquals(response.isErrorStatus(), false);
	}
}
