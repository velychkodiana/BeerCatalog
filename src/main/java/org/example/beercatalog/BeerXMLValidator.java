package org.example.beercatalog;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

public class BeerXMLValidator {
    public static boolean validateXML(String xmlFilePath) {
        try (InputStream xsdStream = BeerXMLValidator.class.getClassLoader().getResourceAsStream("beer.xsd")) {
            if (xsdStream == null) {
                System.out.println("XML is not valid. Error: XSD schema not found in resources.");
                return false;
            }

            // Встановлення фабрики для валідації
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdStream));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFilePath));
            return true;

        } catch (SAXException e) {
            System.out.println("XML is not valid. Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("XML is not valid. Error: Could not read file - " + e.getMessage());
        }
        return false;
    }
}