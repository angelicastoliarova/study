package by.tc.st;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import by.tc.st.dao.DAOFactory;
import by.tc.st.dao.exception.DAOException;

public class Authentication {

	String negativName = "name";
	String negativPass = "pass";

	@Test(dataProvider = "authorizationPositiveTest", dataProviderClass = DataProvider.class)
	public void positiveTest(String login, String password) throws DAOException, SAXException, IOException {

		boolean actual = DAOFactory.getInstance().getUserDAO().registration(login, password);
		Assert.assertEquals(actual, true);

	}
}