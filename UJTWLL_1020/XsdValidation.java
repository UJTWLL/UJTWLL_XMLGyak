package SaxUJTWLL1020;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XsdValidation {
    public static void main(String[] args) throws SAXException, ParserConfigurationException {
        File xml = new File("macskakUJTWLL.xml");
        File xsd = new File("macskakUJTWLL.xsd");

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(xsd);

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setSchema(schema);

        SAXParser parser = spf.newSAXParser();

        XsdValidationHandler handler = new XsdValidationHandler();

        try {
            parser.parse(xml, handler);
            System.out.println("XSD validation successful!");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("XSD validation unsuccessful!");
        }
    }
}

class XsdValidationHandler extends DefaultHandler {
    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        throw e;
    }
}