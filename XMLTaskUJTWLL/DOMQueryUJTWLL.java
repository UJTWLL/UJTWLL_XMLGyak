package hu.domparse.UJTWLL;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class DOMQueryUJTWLL{
    public static void main(String[] argv){
        try{
            File xmlfile = new File("XMLUJTWLL.xml");

            //Dokumentum értelmező létrehozása, példányosítása, fájl beolvasása lekérdezésre
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlfile);

            doc.getDocumentElement().normalize();

            //Gyökérelem létrehozása
            System.out.println("Root element: "+doc.getDocumentElement().getNodeName()+"");

            //Autók számának (gyökér gyerekelemeinek számának) meghatározása
            NodeList nList = doc.getElementsByTagName("auto");
            int childCount = nList.getLength();
            System.out.println("Number of child nodes: "+childCount);
            System.out.println("-------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {
                //Aktuális elem kiíratása
                Node nNode = nList.item(i);
                System.out.println("Current element: " + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    //Adott autó attribútumainak, elemeinek beolvasása
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
                    String tulajRsz = tulaj.getAttribute("rendszam");
                    Node veznevNode = auto.getElementsByTagName("veznev").item(0);
                    String veznev = veznevNode.getTextContent();
                    Node kernevNode = auto.getElementsByTagName("kernev").item(0);
                    String kernev = kernevNode.getTextContent();
                    Node nemNode = auto.getElementsByTagName("nem").item(0);
                    String nem = nemNode.getTextContent();
                    Element garazs = (Element) auto.getElementsByTagName("garazs").item(0);
                    String cim = garazs.getAttribute("cim");
                    String garazsRsz = garazs.getAttribute("rendszam");
                    Node gtulajNode = auto.getElementsByTagName("garazstulaj").item(0);
                    String gtulaj = gtulajNode.getTextContent();
                    Node anyagNode = auto.getElementsByTagName("anyag").item(0);
                    String anyag = anyagNode.getTextContent();
                    Node biztNode = auto.getElementsByTagName("bizt").item(0);
                    String bizt = biztNode.getTextContent();
                    Element karosszeria = (Element) auto.getElementsByTagName("karosszeria").item(0);
                    String alvazszam = karosszeria.getAttribute("alvazszam");
                    String karosszeriaRsz = karosszeria.getAttribute("rendszam");
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
                    String motorRsz = motor.getAttribute("rendszam");
                    Node motorkodNode = auto.getElementsByTagName("motorkod").item(0);
                    String motorkod = motorkodNode.getTextContent();
                    Node loeroNode = auto.getElementsByTagName("loero").item(0);
                    String loero = loeroNode.getTextContent();
                    Node nyomatekNode = auto.getElementsByTagName("nyomatek").item(0);
                    String nyomatek = nyomatekNode.getTextContent();

                    //beolvasott értékek kiíratása
                    System.out.printf("Rendszam: %s%n", rsz);
                    System.out.printf("KGFB: %s%n", kgfb);
                    if(cascoNode != null){
                        System.out.printf("Casco: %s%n", casco);
                    }
                    System.out.printf("Tulajdonos: %18s: %s%n", "Szemelyi szam", szigszam);
                    System.out.printf("%30s: %s%n", "Rendszam", tulajRsz);
                    System.out.printf("%30s: %s%n", "Vezeteknev", veznev);
                    System.out.printf("%30s: %s%n", "Keresztnev", kernev);
                    System.out.printf("%30s: %s%n", "Nem", nem);
                    System.out.printf("Garazs: %22s: %s%n", "Cim", cim);
                    System.out.printf("%30s: %s%n", "Rendszam", garazsRsz);
                    System.out.printf("%30s: %s%n", "Garazsulaj", gtulaj);
                    System.out.printf("%30s: %s%n", "Anyag", anyag);
                    System.out.printf("%30s: %s%n", "Biztositva", bizt);
                    System.out.printf("Karosszeria: %17s: %s%n", "Alvazszam", alvazszam);
                    System.out.printf("%30s: %s%n", "Rendszam", karosszeriaRsz);
                    System.out.printf("%30s: %s%n", "Fenyezes", fenyezes);
                    for(int k = 0; k < szinekNode.getLength(); k++){
                        System.out.printf("%30s: %s%n", "Szin", szinek[k]);
                    }
                    if(matricaNode != null){
                        System.out.printf("%30s: %s%n", "Matrica", matrica);
                    }
                    System.out.printf("Motor: %23s: %s%n", "Motorszam", motorszam);
                    System.out.printf("%30s: %s%n", "Rendszam", motorRsz);
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