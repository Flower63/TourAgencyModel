package ua.epam.tour_agency.data;

import ua.epam.tour_agency.entity.Tour;

import java.util.Comparator;

/**
 * Enumeration to hold comparators
 *
 * @author Dennis
 *
 * on 11/6/2015.
 */
public enum Comparators {
    MAX_PRICE((o1, o2) -> o2.getPrice() - o1.getPrice()),
    MIN_PRICE((o1, o2) -> o1.getPrice() - o2.getPrice()),
    MORE_DAYS((o1, o2) -> o2.getDays() - o1.getDays()),
    FEWER_DAYS((o1, o2) -> o1.getDays() - o2.getDays());

    private Comparator<Tour> comparator;

    Comparators(Comparator<Tour> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Tour> getComparator() {
        return comparator;
    }
}
