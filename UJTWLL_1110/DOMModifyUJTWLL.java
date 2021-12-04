package domujtwll1110;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class DOMModifyUJTWLL {
    public static void main(String[] argv) {
        try {
            File inputFile = new File("nyelvekUJTWLL.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            NodeList nyelvek = doc.getElementsByTagName("nyelv_neve");
            Node o1 = nyelvek.item(0);
            Node o2 = nyelvek.item(1);
            o1.setTextContent("OOP");
            o2.setTextContent("Document-oriented DB");

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