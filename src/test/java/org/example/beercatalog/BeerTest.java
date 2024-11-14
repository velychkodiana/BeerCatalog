package org.example.beercatalog;

import junit.framework.TestCase;
import java.util.Arrays;
import java.util.List;

public class BeerTest extends TestCase {

    public void testGettersAndSetters() {
        Beer beer = new Beer();

        // Перевірка сеттерів і геттерів
        beer.setName("Lager");
        assertEquals("Lager", beer.getName());

        beer.setType("Pale Lager");
        assertEquals("Pale Lager", beer.getType());

        beer.setAlcohol(true);
        assertTrue(beer.isAlcohol());

        beer.setManufacturer("Brewery Co");
        assertEquals("Brewery Co", beer.getManufacturer());

        List<String> ingredients = Arrays.asList("Water", "Barley", "Hops", "Yeast");
        beer.setIngredients(ingredients);
        assertEquals(ingredients, beer.getIngredients());

        List<String> chars = Arrays.asList("Light", "Crisp", "Golden");
        beer.setChars(chars);
        assertEquals(chars, beer.getChars());
    }

    public void testConstructorWithParameters() {
        // Тест конструктора з параметрами
        List<String> ingredients = Arrays.asList("Water", "Barley", "Hops", "Yeast");
        List<String> chars = Arrays.asList("Light", "Crisp", "Golden");

        Beer beer = new Beer("IPA", "India Pale Ale", true, "Craft Brewery", ingredients, chars);

        assertEquals("IPA", beer.getName());
        assertEquals("India Pale Ale", beer.getType());
        assertTrue(beer.isAlcohol());
        assertEquals("Craft Brewery", beer.getManufacturer());
        assertEquals(ingredients, beer.getIngredients());
        assertEquals(chars, beer.getChars());
    }

    public void testToString() {
        List<String> ingredients = Arrays.asList("Water", "Barley", "Hops", "Yeast");
        List<String> chars = Arrays.asList("Light", "Crisp", "Golden");

        Beer beer = new Beer("Pilsner", "Pale Lager", true, "Pilsner Urquell", ingredients, chars);
        String expected = "Beer{name='Pilsner', type='Pale Lager', alcohol=true, manufacturer='Pilsner Urquell', ingredients=[Water, Barley, Hops, Yeast], chars=[Light, Crisp, Golden]}";

        assertEquals(expected, beer.toString());
    }
}
