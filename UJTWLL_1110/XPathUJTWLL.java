package xpathujtwll1110;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import org.xml.sax.SAXException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

public class XPathUJTWLL {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse("studentUJTWLL.xml");
			document.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			//0. feladat: String expression = "class";
			//1., 2., 4. feladat: String expression = "/class/student";
			//3. feladat: ???

			//1. feladat--------------------------------------------------------------------

			/*String expression = "/class/student";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//2. feladat--------------------------------------------------------------------

			/*String expression = "//student[@id='01']";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//3. feladat--------------------------------------------------------------------

			/*String expression = "//student";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//4. feladat--------------------------------------------------------------------

			/*String expression = "/class/student[2]";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//5. feladat--------------------------------------------------------------------

			/*String expression = "/class/student[last()]";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//6. feladat--------------------------------------------------------------------

			/*String expression = "/class/student[last()-1]";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//7. feladat--------------------------------------------------------------------

			/*String expression = "/class/student[position()<3]";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//8. feladat--------------------------------------------------------------------

			/*String expression = "/class/*";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//9. feladat--------------------------------------------------------------------

			/*String expression = "/class/student[@*]";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//10. feladat--------------------------------------------------------------------

			/*String expression = "//*";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}*/

			//11. feladat--------------------------------------------------------------------

			String expression = "/class/student[kor>21]";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for(int j = 0; j < nodeList.getLength(); j++) {
				Node node = nodeList.item(j);
				System.out.println("\nAktuális elem: " + node.getNodeName());

				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
			}
		} catch (ParserConfigurationException p) {
			p.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (SAXException s) {
			s.printStackTrace();
		} catch (XPathExpressionException x) {
			x.printStackTrace();
		}
	}
}