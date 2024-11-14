package org.example.beercatalog;

import org.example.beercatalog.BeerXMLValidator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Шляхи до ваших файлів
        String xmlFilePath = "/Users/macbookpro/Desktop/BeerCatalog/src/main/resources/beer.xml";
        String xsdFilePath = "/Users/macbookpro/Desktop/BeerCatalog/src/main/resources/beer.xsd";
        String xslFilePath = "/Users/macbookpro/Desktop/BeerCatalog/src/main/resources/transform.xsl";
        String transformedXmlFilePath = "/Users/macbookpro/Desktop/BeerCatalog/transformedBeer.xml";

        // Валідація XML, передаємо тільки шлях до XML
        if (BeerXMLValidator.validateXML(xmlFilePath)) {
            System.out.println("XML is valid.");
        } else {
            System.out.println("XML is not valid.");
            return;
        }

        // Парсинг XML
        BeerParserStAX saxParser = new BeerParserStAX();
        List<Beer> beers = saxParser.parseXML(xmlFilePath);

        // Сортування за типом пива
        beers.sort(new BeerComparator());

        // Створення об'єкта для трансформації XML
        BeerXMLTransformer transformer = new BeerXMLTransformer();

        // Трансформація XML за допомогою XSL
        transformer.transformXML(xmlFilePath, xslFilePath, transformedXmlFilePath);
    }
}
