package ua.epam.tour_agency.entity;

import ua.epam.tour_agency.data.Food;
import ua.epam.tour_agency.data.Transport;

import java.time.LocalDate;

/**
 * Class to define wellness tour
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class WellnessTour extends Tour {

    /*
     * Constructor
     */
    public WellnessTour(String country, String town, LocalDate startDate,
                        LocalDate endDate, Transport transport, Food food,
                        int price) {

        super(country, town, startDate, endDate, transport, food, price);
    }

    /*
     * Default constructor
     */
    public WellnessTour() {
    }
}
