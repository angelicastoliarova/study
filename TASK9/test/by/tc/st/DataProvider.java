package by.tc.st;

import java.io.IOException;

import org.xml.sax.SAXException;

public class DataProvider {

	
	@DataProvider(name = "addNewQui")
	public static Object[][] AddNewQui() throws SAXException, IOException {
		Object[][] obj = new Object[1][4];
		obj[0][0] = new String(XMLParcer.getTestData().get(0).getSubjectName().toUpperCase());
		obj[0][1] = new String(XMLParcer.getTestData().get(0).getQuestion());
		obj[0][2] = new Integer(XMLParcer.getTestData().get(0).getAnswer());
		obj[0][3] = new String(XMLParcer.getTestData().get(0).getNewTestCommand());
		return obj;
	}
	
	@DataProvider(name = "authorization")
	public static Object[][] authorizationTest() throws SAXException, IOException {
		Object obj[][] = new Object[1][2];
		obj[0][0] = XMLParcer.getTestData().get(0).getLogin();
		obj[0][1] = XMLParcer.getTestData().get(0).getPassword();

		return obj;
	}
	
	@DataProvider(name = "registration")
	public static Object[][] registrationPositiveTest() throws SAXException, IOException {
		
		 		
		Object obj[][] = new Object [1][3];
		
		obj[0][0] = XMLParcer.getTestData().get(0).getLogin();
		obj[0][1] = XMLParcer.getTestData().get(0).getPassword();
		obj[0][2] = XMLParcer.getTestData().get(0).getRegistrationCommand();

		return obj;
	}
	@DataProvider(name = "findQuiByTest")
	public static Object[][] FindQuiByTest() throws SAXException, IOException {

		Object[][] obj = new Object[1][2];

		obj[0][0] = new String(XMLParcer.getTestData().get(0).getSubjectName().toUpperCase());
		
		
		obj[0][1] = new String(XMLParcer.getTestData().get(0).getShowQuestCommand());

		return obj;
	}
	
	@DataProvider(name = "formNewTest")
	public static Object[][] formNewTest() throws SAXException, IOException {
		Object[][] obj = new Object[1][4];
		obj[0][0] = new String(XMLParcer.getTestData().get(0).getSubjectName().toUpperCase());
		obj[0][1] = new String(XMLParcer.getTestData().get(0).getQuestion());
		obj[0][2] = new Integer(XMLParcer.getTestData().get(0).getAnswer());
		obj[0][3] = new String(XMLParcer.getTestData().get(0).getNewTestCommand());
		return obj;
	}
	
	
}
