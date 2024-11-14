package org.example.beercatalog;

import junit.framework.TestCase;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;

public class BeerParserStAXTest extends TestCase {

    private static final String TEST_XML_FILE = "test_beers_stax.xml";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Створюємо тестовий XML файл для перевірки
        String xmlContent = """
            <Beers>
                <Beer>
                    <Name>Amber Ale</Name>
                    <Type>Ale</Type>
                    <Manufacturer>Brew Co</Manufacturer>
                </Beer>
                <Beer>
                    <Name>Lager</Name>
                    <Type>Lager</Type>
                    <Manufacturer>Brew House</Manufacturer>
                </Beer>
            </Beers>
        """;

        try (FileWriter writer = new FileWriter(TEST_XML_FILE)) {
            writer.write(xmlContent);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        // Видаляємо тестовий XML файл після виконання тестів
        File file = new File(TEST_XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    public void testParseXML() {
        BeerParserStAX parser = new BeerParserStAX();
        List<Beer> beers = parser.parseXML(TEST_XML_FILE);

        // Перевірка кількості об'єктів Beer
        assertEquals(2, beers.size());

        // Перевірка першого об'єкта Beer
        Beer beer1 = beers.get(0);
        assertEquals("Amber Ale", beer1.getName());
        assertEquals("Ale", beer1.getType());
        assertEquals("Brew Co", beer1.getManufacturer());

        // Перевірка другого об'єкта Beer
        Beer beer2 = beers.get(1);
        assertEquals("Lager", beer2.getName());
        assertEquals("Lager", beer2.getType());
        assertEquals("Brew House", beer2.getManufacturer());
    }
}
