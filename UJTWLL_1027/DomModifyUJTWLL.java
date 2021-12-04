package domujtwll1027;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class DomModifyUJTWLL {
    public static void main(String argv[]) {
        try {
            File inputFile = new File("carsUJTWLL.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            Node root = doc.getFirstChild();
            NodeList supercars = doc.getElementsByTagName("supercars");
            Node ferraris;

            for(int i = 0; i < supercars.getLength(); i++){
                NamedNodeMap attrList = supercars.item(i).getAttributes();
                for(int j = 0; j < attrList.getLength(); j++){
                    if(attrList.item(j).getTextContent().equals("Ferrari")){
                        attrList.item(j).setTextContent("Lamborghini");
                    }
                }
            }

            Node luxurycars = doc.getElementsByTagName("luxurycars").item(0);
            root.removeChild(luxurycars);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            System.out.println("-----------Modified XML-----------");
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
