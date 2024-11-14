package org.example.beercatalog;

import junit.framework.TestCase;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;

public class BeerParserDOMTest extends TestCase {

    private static final String TEST_XML_FILE = "test_beers.xml";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Створюємо тестовий XML файл для перевірки
        String xmlContent = """
            <beers>
                <beer name="Amber Ale" type="Ale" alcoholic="true" manufacturer="Brew Co">
                    <ingredient>Malt</ingredient>
                    <ingredient>Hops</ingredient>
                    <ingredient>Yeast</ingredient>
                    <characteristic>Amber</characteristic>
                    <characteristic>Medium</characteristic>
                </beer>
                <beer name="Lager" type="Lager" alcoholic="false" manufacturer="Brew House">
                    <ingredient>Barley</ingredient>
                    <ingredient>Water</ingredient>
                    <characteristic>Light</characteristic>
                    <characteristic>Crisp</characteristic>
                </beer>
            </beers>
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
        BeerParserDOM parser = new BeerParserDOM();
        List<Beer> beers = parser.parseXML(TEST_XML_FILE);

        // Перевірка кількості елементів
        assertEquals(2, beers.size());

        // Перевірка першого об'єкта Beer
        Beer beer1 = beers.get(0);
        assertEquals("Amber Ale", beer1.getName());
        assertEquals("Ale", beer1.getType());
        assertTrue(beer1.isAlcohol());
        assertEquals("Brew Co", beer1.getManufacturer());
        assertEquals(Arrays.asList("Malt", "Hops", "Yeast"), beer1.getIngredients());
        assertEquals(Arrays.asList("Amber", "Medium"), beer1.getChars());

        // Перевірка другого об'єкта Beer
        Beer beer2 = beers.get(1);
        assertEquals("Lager", beer2.getName());
        assertEquals("Lager", beer2.getType());
        assertFalse(beer2.isAlcohol());
        assertEquals("Brew House", beer2.getManufacturer());
        assertEquals(Arrays.asList("Barley", "Water"), beer2.getIngredients());
        assertEquals(Arrays.asList("Light", "Crisp"), beer2.getChars());
    }
}
