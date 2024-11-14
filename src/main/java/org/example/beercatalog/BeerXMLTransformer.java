package org.example.beercatalog;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class BeerXMLTransformer {

    // Зробіть метод статичним
    public static void transformXML(String xmlFilePath, String xslFilePath, String transformedXmlFilePath) {
        try {
            // Створення фабрики трансформерів
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xslStream = new StreamSource(new File(xslFilePath));
            Transformer transformer = factory.newTransformer(xslStream);

            // Вказуємо вхідний та вихідний файли
            StreamSource xmlStream = new StreamSource(new File(xmlFilePath));
            StreamResult result = new StreamResult(new File(transformedXmlFilePath));

            // Застосування трансформації
            transformer.transform(xmlStream, result);
            System.out.println("XML has been transformed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
