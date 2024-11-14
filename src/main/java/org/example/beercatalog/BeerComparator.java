package org.example.beercatalog;

import java.util.Comparator;

public class BeerComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer b1, Beer b2) {
        String name1 = b1.getName();
        String name2 = b2.getName();

        if (name1 == null && name2 == null) {
            return 0;
        } else if (name1 == null) {
            return -1;
        } else if (name2 == null) {
            return 1;
        }

        return name1.compareTo(name2);
    }
}
