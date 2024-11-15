package org.example.beercatalog;

import java.util.Comparator;

public class BeerComparator implements Comparator<Beer> {

    // Метод compare порівнює два об'єкти Beer за назвою пива (name)
    @Override
    public int compare(Beer b1, Beer b2) {
        // Отримуємо назви пива для кожного об'єкта
        String name1 = b1.getName();
        String name2 = b2.getName();

        // Перевірка на випадок, якщо обидва значення є null
        if (name1 == null && name2 == null) {
            return 0; // Якщо обидва значення null, пива рівні
        } else if (name1 == null) {
            return -1; // Якщо лише перше значення null, то воно буде менше
        } else if (name2 == null) {
            return 1; // Якщо лише друге значення null, то воно буде більше
        }

        // Якщо обидва значення не null, порівнюємо їх лексикографічно
        return name1.compareTo(name2);
        // compareTo порівнює два рядки (стрічки) лексикографічно (за алфавітним порядком)
        // повертаємо 0, якщо рядки однакові, від'ємне значення, якщо перший рядок менший,
        // і додатне значення, якщо перший рядок більший.
    }
}
