/*package org.example.beercatalog;

import junit.framework.TestCase;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BeerXMLValidatorTest extends TestCase {

    private static final String VALID_XML_FILE = "valid_beer.xml";
    private static final String INVALID_XML_FILE = "invalid_beer.xml";
    private static final String XSD_FILE = "beer.xsd";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Створюємо тестову XSD схему
        String xsdContent = """
            <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
                <xs:element name="Beers">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="Beer" maxOccurs="unbounded">
                                <xs:complexType>
                                    <xs:sequence>
                                        <xs:element name="Name" type="xs:string"/>
                                        <xs:element name="Type" type="xs:string"/>
                                        <xs:element name="Manufacturer" type="xs:string"/>
                                    </xs:sequence>
                                    <xs:attribute name="alcoholic" type="xs:boolean" use="required"/>
                                </xs:complexType>
                            </xs:element>
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:schema>
        """;

        try (FileWriter writer = new FileWriter(XSD_FILE)) {
            writer.write(xsdContent);
        }

        // Створюємо коректний XML файл
        String validXmlContent = """
            <Beers>
                <Beer alcoholic="true">
                    <Name>Amber Ale</Name>
                    <Type>Ale</Type>
                    <Manufacturer>Brew Co</Manufacturer>
                </Beer>
            </Beers>
        """;

        try (FileWriter writer = new FileWriter(VALID_XML_FILE)) {
            writer.write(validXmlContent);
        }

        // Створюємо некоректний XML файл
        String invalidXmlContent = """
            <Beers>
                <Beer>
                    <Name>Lager</Name>
                    <Type>Lager</Type>
                </Beer>
            </Beers>
        """;

        try (FileWriter writer = new FileWriter(INVALID_XML_FILE)) {
            writer.write(invalidXmlContent);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        // Видаляємо тимчасові файли після тестування
        new File(VALID_XML_FILE).delete();
        new File(INVALID_XML_FILE).delete();
        new File(XSD_FILE).delete();
    }

    public void testValidateXML_ValidFile() {
        assertTrue("Valid XML should pass validation", BeerXMLValidator.validateXML(VALID_XML_FILE));
    }

    public void testValidateXML_InvalidFile() {
        assertFalse("Invalid XML should fail validation", BeerXMLValidator.validateXML(INVALID_XML_FILE));
    }
}
*/