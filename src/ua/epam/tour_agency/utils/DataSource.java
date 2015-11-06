package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.Tour;

import java.util.List;

/**
 * Interface to generalise data initialisation
 * for Tour Agency.
 *
 * Typically it could be database, xml file,
 * local initialisers and so on.
 *
 * @author Dennis
 *
 * on 11/6/2015.
 */
public interface DataSource {

    /**
     * Method to initialise tour data.
     *
     * @return - Available tour data as a list.
     */
    List<Tour> getTours();
}
