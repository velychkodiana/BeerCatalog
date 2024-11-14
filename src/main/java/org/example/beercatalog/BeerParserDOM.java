package org.example.beercatalog;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BeerParserDOM {

    public List<Beer> parseXML(String xmlFilePath) {
        List<Beer> beers = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));

            NodeList beerNodes = document.getElementsByTagName("beer");
            for (int i = 0; i < beerNodes.getLength(); i++) {
                Node beerNode = beerNodes.item(i);
                if (beerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beerElement = (Element) beerNode;
                    String name = beerElement.getAttribute("name");
                    String type = beerElement.getAttribute("type");
                    boolean isAlcoholic = Boolean.parseBoolean(beerElement.getAttribute("alcoholic"));
                    String manufacturer = beerElement.getAttribute("manufacturer");

                    List<String> ingredients = new ArrayList<>();
                    NodeList ingredientNodes = beerElement.getElementsByTagName("ingredient");
                    for (int j = 0; j < ingredientNodes.getLength(); j++) {
                        ingredients.add(ingredientNodes.item(j).getTextContent());
                    }

                    List<String> characteristics = new ArrayList<>();
                    NodeList characteristicNodes = beerElement.getElementsByTagName("characteristic");
                    for (int j = 0; j < characteristicNodes.getLength(); j++) {
                        characteristics.add(characteristicNodes.item(j).getTextContent());
                    }

                    beers.add(new Beer(name, type, isAlcoholic, manufacturer, ingredients, characteristics));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beers;
    }
}
