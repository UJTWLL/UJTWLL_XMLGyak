package hu.domparse.UJTWLL;

import java.io.File;
import java.io.IOException;
//import javax.xml.XMLConstants;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
/*import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;*/
import javax.xml.transform.TransformerFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
//import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class DOMReadUJTWLL{
    public static void main(String[] args){
        try{
            //Dokumentumolvasó létrehozása
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            //SAX értelmező példányosítása, a gyár állítja elő a SAX elemzőt
            SAXParser saxParser = saxParserFactory.newSAXParser();

            //saját eseménykezelő objektum létrehozása
            SaxHandler handler = new SaxHandler();

            //dokumentum értelmezésének indítása
            saxParser.parse(new File("XMLUJTWLL.xml"), handler);
        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}

//tartalomkezelő keret létrehozása, esemény- és hibakezelő metódusok definiálása
class SaxHandler extends DefaultHandler{
    private int indent = 0;

    private String formatAttributes(Attributes attributes){
        int attrLength = attributes.getLength();
        if(attrLength == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(", {");
        for(int i = 0; i < attrLength; i++){
            sb.append(attributes.getLocalName(i) + ":" + attributes.getValue(i));
            if(i < attrLength - 1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private void indent(){
        for(int i = 0; i < indent; i++){
            System.out.print("  ");
        }
    }

    //Eseménykezelő metódusok létrehozása, startElement metódus újraimplementálása
    @Override
    //Elem kezdete és vége
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        indent++;
        indent();
        System.out.println(qName + formatAttributes(attributes) + " start");
    }

    @Override //endElement metódust újraimplementáljuk
    public void endElement(String uri, String localName, String qName){
        indent();
        indent--;
        System.out.println(qName + " end");
    }

    //Szövegelem feldolgozása, characters metódus újraimplementálása
    @Override
    public void characters(char ch[], int start, int length){
        String chars = new String(ch, start, length).trim();
        if(!chars.isEmpty()){
            indent++;
            indent();
            indent--;
            System.out.println(chars);
        }
    }
}