package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.Messages;
import ua.epam.tour_agency.entity.Tour;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Application's view class.
 * Performs console output by three specified templates
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public interface View {

    /**
     * Prints single message
     *
     * @param message - input message as a String
     */
    static void print(String message) {
        System.out.println(message);
    }

    /**
     * Prints given tour as set of data
     *
     * @param tour - input Tour object
     */
    static void printTour(Tour tour) {
        print(Messages.DIV);
        print(tour.getCountry() + " " + tour.getTown() + ", " + tour.getDays() + " days.");
        print("Type: " + tour.getSubject());
        print("from " + tour.getStartDate() + " to " + tour.getEndDate());
        print("Transport: " + tour.getTransport() + " Food: " + tour.getFood());
        print("Price: " + tour.getPrice() + " $");
    }

    /**
     * Prints list of given tours.
     *
     * This method iterates over list and prints tours
     * by calling printTour() method
     *
     * @param tours - input list of tours
     */
    static void printTours(List<Tour> tours) {
        for (Tour tour : tours) {
            printTour(tour);
        }

        print(Messages.DIV);
    }
}
