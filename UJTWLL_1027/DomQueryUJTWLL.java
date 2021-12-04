package domujtwll1027;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class DomQueryUJTWLL{
    public static void main(String argv[]){
        try{
            File xmlfile = new File("carsUJTWLL.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlfile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: "+doc.getDocumentElement().getNodeName()+"");

            NodeList nList = doc.getElementsByTagName("supercars");
            int childCount = nList.getLength();
            System.out.println("Number of child nodes: "+childCount);
            System.out.println("-------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Current element: \n");

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element auto = (Element) nNode;
                    String company = auto.getAttribute("company");
                    NodeList carsNode = auto.getElementsByTagName("carname");
                    String[] carnames = new String[carsNode.getLength()];
                    String[] cartypes = new String[carsNode.getLength()];
                    for(int j = 0; j < carsNode.getLength(); j++){
                        carnames[j] = carsNode.item(j).getTextContent();
                        cartypes[j] = ((Element)carsNode.item(j)).getAttribute("type");
                    }

                    for(int k = 0; k < carnames.length; k++){
                        System.out.printf("Supercars company: %s%n", company);
                        System.out.printf("Car name: %s%n", carnames[k]);
                        System.out.printf("Car type: %s%n%n", cartypes[k]);
                    }

                    System.out.println("-------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}