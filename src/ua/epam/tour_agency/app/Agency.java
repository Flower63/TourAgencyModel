package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.TourSubject;
import ua.epam.tour_agency.entity.*;
import ua.epam.tour_agency.utils.DataSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Layer class to work with logic and data
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class Agency {

    /**
     * List of all tours
     */
    private List<Tour> allTours;

    /**
     * Constructor
     *
     * Here we call getSource() method of DataSource object
     * to initialise collections of tours.
     */
    public Agency(DataSource source) {
        allTours = source.getTours();
    }

    /**
     * Filter method thad filters all tours with specified type
     * (e.g. CRUISE of CULTURE or so.)
     *
     * @param subject - specified type of tour
     * @return list of tours, which matches given type
     */
    public List<Tour> filter(TourSubject subject) {
        List<Tour> results = new ArrayList<>();

        for (Tour tour : allTours) {
            if (tour.getSubject() == subject) {
                results.add(tour);
            }
        }

        return results;
    }

    /**
     * Method to get entire list of existing tours without filtration
     *
     * @return - List of all available tours
     */
    public List<Tour> getAllTours() {
        return allTours;
    }

    /**
     * Sorts given list of tours with specified comparator
     *
     * @param tours - List of tours to sort
     * @param comparator - Sorting clause
     */
    public void sort(List<Tour> tours, Comparator<Tour> comparator) {
        tours.sort(comparator);
    }
}
