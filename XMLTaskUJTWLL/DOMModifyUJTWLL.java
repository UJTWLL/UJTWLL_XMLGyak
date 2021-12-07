package hu.domparse.UJTWLL;

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
            //Dokumentum értelmező létrehozása, példányosítása, fájl beolvasása módosításra
            File inputFile = new File("XMLUJTWLL.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            //1.feladat: A második autó rendszámának megváltoztatása
            Node masodikAuto = doc.getElementsByTagName("auto").item(1);
            NamedNodeMap attr = masodikAuto.getAttributes();
            Node nodeAttr = attr.getNamedItem("rendszam");
            nodeAttr.setTextContent("PJV931");

            //2.feladat: CASCO eltávolítása az összes autóról
            NodeList autoLista = doc.getElementsByTagName("auto");
            for(int i = 0; i < autoLista.getLength(); i++){
                Node autoNode = autoLista.item(i);
                NodeList elemLista = autoNode.getChildNodes();
                for(int j = 0; j < elemLista.getLength(); j++){
                    Node elemNode = elemLista.item(j);
                    if(elemNode.getNodeName().equals("casco")){
                        autoNode.removeChild(elemNode);
                    }
                }
            }

            //3.feladat: A matricával rendelkező autókhoz szürke szín hozzáadása
            NodeList matrica = doc.getElementsByTagName("matrica");
            Node newNode = doc.createElement("szin");
            Text text = doc.createTextNode("Szürke");
            newNode.appendChild(text);
            for(int k = 0; k < matrica.getLength(); k++){
                matrica.item(k).getParentNode().insertBefore(newNode, matrica.item(k));
            }

            //Módosított dokumentum "transzformálása", transzformáló létrehozása, példányosítása
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            //Módosított dokumentum adatainak kiíratása
            System.out.println("-----------Modositott XML-----------");
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
