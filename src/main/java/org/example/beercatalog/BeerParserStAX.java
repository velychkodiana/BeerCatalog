package org.example.beercatalog;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeerParserStAX {

    public List<Beer> parseXML(String filePath) {
        List<Beer> beers = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

            Beer currentBeer = null;
            String elementName = null;

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        elementName = reader.getLocalName();
                        if ("Beer".equals(elementName)) {
                            currentBeer = new Beer();  // Використовуємо конструктор за замовчуванням
                        } else if ("Name".equals(elementName)) {
                            currentBeer.setName(reader.getElementText());
                        } else if ("Type".equals(elementName)) {
                            currentBeer.setType(reader.getElementText());
                        } else if ("Manufacturer".equals(elementName)) {
                            currentBeer.setManufacturer(reader.getElementText());
                        } else if ("Ingredients".equals(elementName)) {
                            // Логіка для обробки інгредієнтів
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        elementName = reader.getLocalName();
                        if ("Beer".equals(elementName)) {
                            beers.add(currentBeer);  // Додаємо пиво в список
                        }
                        break;
                }
            }
            reader.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

        return beers;  // Повертаємо список пив
    }
}