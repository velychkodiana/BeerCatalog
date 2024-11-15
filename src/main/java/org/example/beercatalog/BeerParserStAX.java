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

    // Метод для парсингу XML файлу за допомогою StAX парсера
    public List<Beer> parseXML(String filePath) {
        // Створюємо список для збереження об'єктів пива
        List<Beer> beers = new ArrayList<>();
        
        // Створюємо фабрику для створення XMLStreamReader
        XMLInputFactory factory = XMLInputFactory.newInstance();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            // Створюємо XMLStreamReader для читання XML
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

            // Створюємо змінні для зберігання поточного пива та імені елемента
            Beer currentBeer = null;
            String elementName = null;

            // Читаємо XML файл по черзі
            while (reader.hasNext()) {
                // Отримуємо наступний подія в потоці
                int event = reader.next();

                // Обробляємо події початкових елементів
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        // Отримуємо ім'я поточного елемента
                        elementName = reader.getLocalName();
                        
                        // Якщо зустріли елемент "Beer", створюємо новий об'єкт пива
                        if ("Beer".equals(elementName)) {
                            currentBeer = new Beer();  // Використовуємо конструктор за замовчуванням
                        } else if ("Name".equals(elementName)) {
                            // Якщо елемент "Name", зчитуємо його текст і встановлюємо для поточного пива
                            currentBeer.setName(reader.getElementText());
                        } else if ("Type".equals(elementName)) {
                            // Якщо елемент "Type", зчитуємо його текст і встановлюємо для поточного пива
                            currentBeer.setType(reader.getElementText());
                        } else if ("Manufacturer".equals(elementName)) {
                            // Якщо елемент "Manufacturer", зчитуємо його текст і встановлюємо для поточного пива
                            currentBeer.setManufacturer(reader.getElementText());
                        } else if ("Ingredients".equals(elementName)) {
                            // Логіка для обробки інгредієнтів (можна додати, якщо потрібно)
                        }
                        break;
                    // Обробляємо події кінцевих елементів
                    case XMLStreamReader.END_ELEMENT:
                        // Отримуємо ім'я кінцевого елемента
                        elementName = reader.getLocalName();
                        // Якщо зустріли елемент "Beer", додаємо поточне пиво до списку
                        if ("Beer".equals(elementName)) {
                            beers.add(currentBeer);  // Додаємо пиво в список
                        }
                        break;
                }
            }
            // Закриваємо reader після завершення парсингу
            reader.close();
        } catch (XMLStreamException | IOException e) {
            // Виводимо помилки, якщо вони виникли
            e.printStackTrace();
        }

        // Повертаємо список з пивом
        return beers;
    }
}
