package ua.epam.tour_agency.entity;

import java.time.LocalDate;

/**
 * Class to define culture tour
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class CultureTour extends Tour {

    /*
     * Constructor
     */
    public CultureTour(String country, String town, LocalDate startDate,
                       LocalDate endDate, Transport transport, Food food,
                       int price) {

        super(country, town, startDate, endDate, transport, food, price);
    }

    /*
     * Default constructor
     */
    public CultureTour() {
    }
}
