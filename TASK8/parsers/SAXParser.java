package by.epam.parsers;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXParser {

	public static void main(String[] args) throws Exception {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		SAXHandler handler = new SAXHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("src/by/epam/parsers/EmployeeXMLSchema.xml"));
		for (Employee emp : handler.empList) {
			System.out.println(emp);
		}
	}
}

class SAXHandler extends DefaultHandler {

	List<Employee> empList = new ArrayList<>();
	Employee emp = null;
	String content = null;

	@Override

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {

		case "tns:employee":
			emp = new Employee();
			emp.id = attributes.getValue("id");
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {

		case "tns:employee":
			empList.add(emp);
			break;

		case "tns:firstName":
			emp.firstName = content;
			break;
		case "tns:lastName":
			emp.lastName = content;
			break;
		case "tns:location":
			emp.location = content;
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}
