package ua.epam.tour_agency.entity;

import ua.epam.tour_agency.data.Food;
import ua.epam.tour_agency.data.Transport;

import java.time.LocalDate;

/**
 * Class to define cruise tour
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class CruiseTour extends Tour {

    /*
     * Constructor
     */
    public CruiseTour(String country, String town, LocalDate startDate,
                      LocalDate endDate, Transport transport, Food food,
                      int price) {

        super(country, town, startDate, endDate, transport, food, price);
    }

    /*
     * Default constructor
     */
    public CruiseTour() {
    }
}
