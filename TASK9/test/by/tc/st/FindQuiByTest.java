package by.tc.st;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.tc.st.bean.FindTestRequest;
import by.tc.st.bean.Response;
import by.tc.st.controller.Controller;

public class FindQuiByTest {

	
	@Test(dataProvider = "findQuiByTest", dataProviderClass = DataProvider.class)
	public void findQuiByTest (int testId, String commandName) {

		Response response = new Response();
		Controller controller = new Controller();
		FindTestRequest request = new FindTestRequest();
		request.setCommandName(commandName);
		request.setTestId(testId);
		response = controller.doRequest(request);

		Assert.assertEquals(response.isErrorStatus(), false, "error");
	}

	
}
