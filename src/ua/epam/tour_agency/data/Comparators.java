/*
 * Interface to hold constants
 */

package ua.epam.tour_agency.data;

import ua.epam.tour_agency.entity.Tour;

import java.util.Comparator;

/**
 * This interface is used to hold comparators instances
 * to represent different type of sorts
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public interface Comparators {

    /**
     * Represents sort by price, from LOW to HIGH
     */
    Comparator<Tour> MIN_PRICE = ((o1, o2) -> {
        if (o1.getPrice() != o2.getPrice()) {
            return o1.getPrice() - o2.getPrice();
        }

        if (!o1.getCountry().equals(o2.getCountry())) {
            return o1.getCountry().compareTo(o2.getCountry());
        }

        if (!o1.getTown().equals(o2.getTown())) {
            return o1.getTown().compareTo(o2.getTown());
        }

        return o1.getDays() - o2.getDays();
    });

    /**
     * Represents sort by price, from HIGH to LOW
     */
    Comparator<Tour> MAX_PRICE = ((o2, o1) -> {
        if (o1.getPrice() != o2.getPrice()) {
            return o1.getPrice() - o2.getPrice();
        }

        if (!o1.getCountry().equals(o2.getCountry())) {
            return o1.getCountry().compareTo(o2.getCountry());
        }

        if (!o1.getTown().equals(o2.getTown())) {
            return o1.getTown().compareTo(o2.getTown());
        }

        return o1.getDays() - o2.getDays();
    });

    /**
     * Represents sort by days count, from FEW to MORE
     */
    Comparator<Tour> FEWER_DAYS = ((o1, o2) -> {
        if (o1.getDays() != o2.getDays()) {
            return o1.getDays() - o2.getDays();
        }

        if (o1.getPrice() != o2.getPrice()) {
            return o1.getPrice() - o2.getPrice();
        }

        if (!o1.getCountry().equals(o2.getCountry())) {
            return o1.getCountry().compareTo(o2.getCountry());
        }

        return o1.getTown().compareTo(o2.getTown());
    });

    /**
     * Represents sort by days count, from MORE to FEW
     */
    Comparator<Tour> MORE_DAYS = ((o2, o1) -> {
        if (o1.getDays() != o2.getDays()) {
            return o1.getDays() - o2.getDays();
        }

        if (o1.getPrice() != o2.getPrice()) {
            return o1.getPrice() - o2.getPrice();
        }

        if (!o1.getCountry().equals(o2.getCountry())) {
            return o1.getCountry().compareTo(o2.getCountry());
        }

        return o1.getTown().compareTo(o2.getTown());
    });

}
