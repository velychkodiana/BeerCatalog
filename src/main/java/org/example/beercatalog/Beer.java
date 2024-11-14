package org.example.beercatalog;

import java.util.List;
import java.util.Comparator;

public class Beer {
    private String name;
    private String type;
    private boolean alcohol;
    private String manufacturer;
    private List<String> ingredients;
    private List<String> chars;

    // Конструктор за замовчуванням
    public Beer() {
    }

    // Конструктор з параметрами (для випадку, якщо ви хочете використовувати його)
    public Beer(String name, String type, boolean alcohol, String manufacturer, List<String> ingredients, List<String> chars) {
        this.name = name;
        this.type = type;
        this.alcohol = alcohol;
        this.manufacturer = manufacturer;
        this.ingredients = ingredients;
        this.chars = chars;
    }

    // Сеттер та геттер для кожного поля
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setAlcohol(boolean alcohol) { this.alcohol = alcohol; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }
    public void setChars(List<String> chars) { this.chars = chars; }

    // Геттери
    public String getName() { return name; }
    public String getType() { return type; }
    public boolean isAlcohol() { return alcohol; }
    public String getManufacturer() { return manufacturer; }
    public List<String> getIngredients() { return ingredients; }
    public List<String> getChars() { return chars; }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", alcohol=" + alcohol +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=" + ingredients +
                ", chars=" + chars +
                '}';
    }
}