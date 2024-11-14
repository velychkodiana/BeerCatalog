package org.example.beercatalog;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class BeerSAXParser {

    public void parseXML(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            BeerHandler handler = new BeerHandler();
            saxParser.parse(new File(filePath), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class BeerHandler extends DefaultHandler {

        private boolean isName = false;
        private boolean isType = false;
        private boolean isAlcohol = false;
        private boolean isManufacturer = false;
        private boolean isIngredient = false;
        private boolean isChar = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName) {
                case "Name" -> isName = true;
                case "Type" -> isType = true;
                case "Alcohol" -> isAlcohol = true;
                case "Manufacturer" -> isManufacturer = true;
                case "Ingredient" -> isIngredient = true;
                case "Char" -> isChar = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("Beer".equals(qName)) {
                System.out.println("End of Beer\n");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length).trim();
            if (isName) {
                System.out.println("Name: " + content);
                isName = false;
            } else if (isType) {
                System.out.println("Type: " + content);
                isType = false;
            } else if (isAlcohol) {
                System.out.println("Alcohol: " + content);
                isAlcohol = false;
            } else if (isManufacturer) {
                System.out.println("Manufacturer: " + content);
                isManufacturer = false;
            } else if (isIngredient) {
                System.out.println("Ingredient: " + content);
                isIngredient = false;
            } else if (isChar) {
                System.out.println("Char: " + content);
                isChar = false;
            }
        }
    }

    public static void main(String[] args) {
        BeerSAXParser parser = new BeerSAXParser();
        parser.parseXML("path/to/your/beer_catalog.xml");
    }
}