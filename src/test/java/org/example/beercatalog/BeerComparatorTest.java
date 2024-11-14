package org.example.beercatalog;

import junit.framework.TestCase;

public class BeerComparatorTest extends TestCase {

    public void testCompareWithNonNullNames() {
        Beer beer1 = new Beer();
        beer1.setName("Amber Ale");

        Beer beer2 = new Beer();
        beer2.setName("Blonde Ale");

        BeerComparator comparator = new BeerComparator();

        // Перевірка порівняння з різними іменами
        assertTrue(comparator.compare(beer1, beer2) < 0);
        assertTrue(comparator.compare(beer2, beer1) > 0);

        // Перевірка порівняння однакових імен
        beer2.setName("Amber Ale");
        assertEquals(0, comparator.compare(beer1, beer2));
    }

    public void testCompareWithNullNames() {
        Beer beer1 = new Beer();
        beer1.setName(null);

        Beer beer2 = new Beer();
        beer2.setName(null);

        BeerComparator comparator = new BeerComparator();

        // Перевірка порівняння, коли обидва імена null
        assertEquals(0, comparator.compare(beer1, beer2));

        // Перевірка, коли одне з імен null
        beer1.setName("Amber Ale");
        assertTrue(comparator.compare(beer1, beer2) > 0);
        assertTrue(comparator.compare(beer2, beer1) < 0);
    }
}
