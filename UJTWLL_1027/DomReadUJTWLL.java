package domujtwll1027;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class DomReadUJTWLL{
    public static void main(String[] argv){
        try{
            File xmlfile = new File("usersUJTWLL.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlfile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: "+doc.getDocumentElement().getNodeName()+"");

            NodeList nList = doc.getElementsByTagName("user");
            int childCount = nList.getLength();
            System.out.println("Number of child nodes: "+childCount);
            System.out.println("-------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Current element: " + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element user = (Element) nNode;
                    String id = user.getAttribute("id");
                    Node fnameNode = user.getElementsByTagName("firstname").item(0);
                    String fname = fnameNode.getTextContent();
                    Node lnameNode = user.getElementsByTagName("lastname").item(0);
                    String lname = lnameNode.getTextContent();
                    Node professionNode = user.getElementsByTagName("profession").item(0);
                    String profession = professionNode.getTextContent();



                    System.out.printf("ID: %s%n", id);
                    System.out.printf("First name: %s%n", fname);
                    System.out.printf("Last name: %s%n", lname);
                    System.out.printf("Profession: %s%n", profession);
                    System.out.println("-------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}