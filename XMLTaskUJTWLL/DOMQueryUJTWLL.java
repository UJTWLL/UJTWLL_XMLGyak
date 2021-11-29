package hu.domparse.UJTWLL;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class DOMQueryUJTWLL{
    public static void main(String argv[]){
        try{
            File xmlfile = new File("XMLUJTWLL.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlfile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: "+doc.getDocumentElement().getNodeName()+"");

            NodeList nList = doc.getElementsByTagName("auto");
            int childCount = nList.getLength();
            System.out.println("Number of child nodes: "+childCount);
            System.out.println("-------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Current element: " + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element auto = (Element) nNode;
                    String rsz = auto.getAttribute("rendszam");
                    Node kgfbNode = auto.getElementsByTagName("kgfb").item(0);
                    String kgfb = kgfbNode.getTextContent();
                    Node cascoNode = auto.getElementsByTagName("casco").item(0);
                    String casco = "";
                    if(cascoNode != null){
                        casco = cascoNode.getTextContent();
                    }
                    Element tulaj = (Element) auto.getElementsByTagName("tulaj").item(0);
                    String szigszam = tulaj.getAttribute("szigszam");
                    Node veznevNode = auto.getElementsByTagName("veznev").item(0);
                    String veznev = veznevNode.getTextContent();
                    Node kernevNode = auto.getElementsByTagName("kernev").item(0);
                    String kernev = kernevNode.getTextContent();
                    Node nemNode = auto.getElementsByTagName("nem").item(0);
                    String nem = nemNode.getTextContent();
                    Element gyarto = (Element) auto.getElementsByTagName("gyarto").item(0);
                    String marka = gyarto.getAttribute("marka");
                    Node kozpontNode = auto.getElementsByTagName("kozpont").item(0);
                    String kozpont = kozpontNode.getTextContent();
                    Node igazgatoNode = auto.getElementsByTagName("igazgato").item(0);
                    String igazgato = igazgatoNode.getTextContent();
                    Node premiumNode = auto.getElementsByTagName("premium").item(0);
                    String premium = premiumNode.getTextContent();
                    Element karosszeria = (Element) auto.getElementsByTagName("karosszeria").item(0);
                    String alvazszam = karosszeria.getAttribute("alvazszam");
                    Node fenyezesNode = auto.getElementsByTagName("fenyezes").item(0);
                    String fenyezes = fenyezesNode.getTextContent();
                    NodeList szinekNode = auto.getElementsByTagName("szin");
                    String[] szinek = new String[szinekNode.getLength()];
                    for(int j = 0; j < szinekNode.getLength(); j++){
                        szinek[j] = szinekNode.item(j).getTextContent();
                    }
                    Node matricaNode = auto.getElementsByTagName("matrica").item(0);
                    String matrica = "";
                    if(matricaNode != null){
                        matrica = matricaNode.getTextContent();
                    }
                    Element motor = (Element) auto.getElementsByTagName("motor").item(0);
                    String motorszam = motor.getAttribute("motorszam");
                    Node motorkodNode = auto.getElementsByTagName("motorkod").item(0);
                    String motorkod = motorkodNode.getTextContent();
                    Node loeroNode = auto.getElementsByTagName("loero").item(0);
                    String loero = loeroNode.getTextContent();
                    Node nyomatekNode = auto.getElementsByTagName("nyomatek").item(0);
                    String nyomatek = nyomatekNode.getTextContent();

                    System.out.printf("Rendszam: %s%n", rsz);
                    System.out.printf("KGFB: %s%n", kgfb);
                    if(cascoNode != null){
                        System.out.printf("Casco: %s%n", casco);;
                    }
                    System.out.printf("Tulajdonos: %18s: %s%n", "Szemelyi szam", szigszam);
                    System.out.printf("%30s: %s%n", "Vezeteknev", veznev);
                    System.out.printf("%30s: %s%n", "Keresztnev", kernev);
                    System.out.printf("%30s: %s%n", "Nem", nem);
                    System.out.printf("Gyarto: %22s: %s%n", "Marka", marka);
                    System.out.printf("%30s: %s%n", "Kozpont", kozpont);
                    System.out.printf("%30s: %s%n", "Igazgato", igazgato);
                    System.out.printf("%30s: %s%n", "Premium", premium);
                    System.out.printf("Karosszeria: %17s: %s%n", "Alvazszam", alvazszam);
                    System.out.printf("%30s: %s%n", "Fenyezes", fenyezes);
                    for(int k = 0; k < szinekNode.getLength(); k++){
                        System.out.printf("%30s: %s%n", "Szin", szinek[k]);
                    }
                    if(matricaNode != null){
                        System.out.printf("%30s: %s%n", "Matrica", matrica);;
                    }
                    System.out.printf("Motor: %23s: %s%n", "Motorszam", motorszam);
                    System.out.printf("%30s: %s%n", "Motorkod", motorkod);
                    System.out.printf("%30s: %s%n", "Loero", loero);
                    System.out.printf("%30s: %s%n", "Nyomatek", nyomatek);
                    System.out.println("-------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}