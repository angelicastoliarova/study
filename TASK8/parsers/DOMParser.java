package by.epam.parsers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory1.newDocumentBuilder();
		Document document = builder.parse("src/by/epam/parsers/EmployeeXMLSchema.xml");

		List<Employee> empList = new ArrayList<>();

		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Employee emp = new Employee();
				emp.id = node.getAttributes().getNamedItem("id").getNodeValue();

				NodeList childNodes = node.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);

					if (cNode instanceof Element) {
						String content = cNode.getLastChild().getTextContent().trim();
						switch (cNode.getNodeName()) {
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
				}
				empList.add(emp);
			}

		}

		for (Employee emp : empList) {
			System.out.println(emp);
		}

	}
}
