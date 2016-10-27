package by.tc.st;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParcer {
	private static Container Store = new Container();

	private static List<Container> DataList = new ArrayList<Container>();



	public static List<Container> getTestData() throws SAXException, IOException, ParserConfigurationException {

		NodeList positiveData = null;
		Element root = getElement();
		
		DataList.clear();
		
		positiveData = root.getElementsByTagName("test");
			
		for (int k = 0; k < positiveData.getLength(); k++) {
				Element temp = (Element) positiveData.item(k);
				Store.setAnswer(Integer.parseInt((getSingleChild(temp, "IdQuetions").getTextContent().trim())));
				Store.setLogin(getSingleChild(temp, "Quetion").getTextContent().trim());
				Store.setSubjectName(getSingleChild(temp, "IdSubject").getTextContent().trim());
				Store.setPassword(getSingleChild(temp, "Subject").getTextContent().trim());
				Store.setQuestion(getSingleChild(temp, "IdTest").getTextContent().trim());
				
				Store.setSubjectID(Integer.parseInt(getSingleChild(temp, "IdCorrectAnswer").getTextContent().trim()));
				Store.setSubjectID(Integer.parseInt(getSingleChild(temp, "CorrectAnswer").getTextContent().trim()));
				Store.setSubjectID(Integer.parseInt(getSingleChild(temp, "LOGIN").getTextContent().trim()));
				Store.setSubjectID(Integer.parseInt(getSingleChild(temp, "PASSWORD").getTextContent().trim()));
				Store.setSubjectID(Integer.parseInt(getSingleChild(temp, "ROLE").getTextContent().trim()));
				Store.setSubjectID(Integer.parseInt(getSingleChild(temp, "TESTANSWER").getTextContent().trim()));
				
				Store.setAuthorizationCommand(getSingleChild(temp, "COMMAND_AUTHORIZATION").getTextContent().trim());
				Store.setRegistrationCommand(getSingleChild(temp, "COMMAND_REGISTRATION").getTextContent().trim());
				Store.setShowSubjectCommand(getSingleChild(temp, "SHOW_SUBJECT-command").getTextContent().trim());
				Store.setGoTestCommand(getSingleChild(temp, "COMMAND_ADD_NEW_QUI").getTextContent().trim());
				Store.setShowQuestCommand(getSingleChild(temp, "COMMAND_FIND_QUI_BY_TEST").getTextContent().trim());
				Store.setNewTestCommand(getSingleChild(temp, "COMMAND_FORM_NEW_TEST").getTextContent().trim());
				Store.setNewSubjectCommand(getSingleChild(temp, "COMMAND_SHOW_ALL_TESTS").getTextContent().trim());

				DataList.add(Store);
			}
		

		return DataList;

	}
	

		private static Element getSingleChild(Element element, String childName) {
			NodeList nList = element.getElementsByTagName(childName);
			Element child = (Element) nList.item(0);
			return child;
		}

	
		private static Element getElement() throws SAXException, IOException, ParserConfigurationException {

	
			
			DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
				builder = factory1.newDocumentBuilder();
				Document document = builder.parse("../test/by/tc/st/NewXMLSchema.xml");
				Element root = document.getDocumentElement();
				return root;
		
		}

	
}
