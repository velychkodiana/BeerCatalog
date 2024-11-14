/*package org.example.beercatalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MainTest {

    private BeerXMLValidator mockValidator;
    private BeerParserStAX mockParser;
    private BeerXMLTransformer mockTransformer;
    private List<Beer> mockBeers;

    @BeforeEach
    public void setUp() {
        // Імітуємо залежності
        mockValidator = mock(BeerXMLValidator.class);
        mockParser = mock(BeerParserStAX.class);
        mockTransformer = mock(BeerXMLTransformer.class);

        mockBeers = mock(List.class);
    }

    @Test
    public void testXMLValidationSuccess() {
        // Імітуємо, що валідація успішна
        when(mockValidator.validateXML(anyString())).thenReturn(true);

        // Перевірка, що виводиться "XML is valid."
        if (mockValidator.validateXML("/path/to/xml")) {
            System.out.println("XML is valid.");
        } else {
            fail("Expected valid XML.");
        }

        // Перевірка, що метод validateXML був викликаний
        verify(mockValidator).validateXML(anyString());
    }

    @Test
    public void testXMLValidationFailure() {
        // Імітуємо, що валідація не пройшла
        when(mockValidator.validateXML(anyString())).thenReturn(false);

        // Перевірка, що виводиться "XML is not valid."
        if (!mockValidator.validateXML("/path/to/xml")) {
            System.out.println("XML is not valid.");
        } else {
            fail("Expected invalid XML.");
        }

        // Перевірка, що метод validateXML був викликаний
        verify(mockValidator).validateXML(anyString());
    }

    @Test
    public void testBeerParsing() {
        // Імітуємо результат парсингу
        when(mockParser.parseXML(anyString())).thenReturn(mockBeers);

        // Перевірка, що список пив згенерований
        List<Beer> beers = mockParser.parseXML("/path/to/xml");
        assertNotNull(beers);

        // Перевірка, що метод parseXML був викликаний
        verify(mockParser).parseXML(anyString());
    }

    @Test
    public void testBeerSorting() {
        // Імітуємо результат парсингу пива
        when(mockParser.parseXML(anyString())).thenReturn(mockBeers);

        // Викликаємо метод сортування
        mockBeers.sort(new BeerComparator());

        // Перевірка, що сортування було викликане
        verify(mockBeers).sort(any(BeerComparator.class));
    }

    @Test
    public void testXMLTransformation() {
        // Перевірка, що трансформація відбудеться без помилок
        doNothing().when(mockTransformer).transformXML(anyString(), anyString(), anyString());

        // Викликаємо метод трансформації
        mockTransformer.transformXML("/path/to/xml", "/path/to/xsl", "/path/to/output");

        // Перевірка, що метод transformXML був викликаний
        verify(mockTransformer).transformXML(anyString(), anyString(), anyString());
    }
}
*/