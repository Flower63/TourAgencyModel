package ua.epam.tour_agency.entity;

import java.time.LocalDate;

/**
 * Class to define shopping tour
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class ShoppingTour extends Tour {

    /*
     * Constructor
     */
    public ShoppingTour(String country, String town, LocalDate startDate,
                        LocalDate endDate, Transport transport, Food food,
                        int price) {

        super(country, town, startDate, endDate, transport, food, price);
    }

    /*
     * Default constructor
     */
    public ShoppingTour() {
    }
}