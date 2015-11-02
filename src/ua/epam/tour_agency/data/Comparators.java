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
    Comparator<Tour> MIN_PRICE = (o1, o2) -> o1.getPrice() - o2.getPrice();

    /**
     * Represents sort by price, from HIGH to LOW
     */
    Comparator<Tour> MAX_PRICE = (o1, o2) -> o2.getPrice() - o1.getPrice();

    /**
     * Represents sort by days count, from FEW to MORE
     */
    Comparator<Tour> FEWER_DAYS = (o1, o2) -> o1.getDays() - o2.getDays();

    /**
     * Represents sort by days count, from MORE to FEW
     */
    Comparator<Tour> MORE_DAYS = (o1, o2) -> o2.getDays() - o1.getDays();
}
