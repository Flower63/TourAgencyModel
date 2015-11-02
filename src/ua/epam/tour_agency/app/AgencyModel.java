package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.Messages;
import ua.epam.tour_agency.entity.*;
import ua.epam.tour_agency.utils.Comparators;
import ua.epam.tour_agency.utils.DataSource;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Layer class to work with logic and data
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class AgencyModel {

    /*
     * Controller instance
     */
    private Controller controller;

    private List<Tour> cruiseTours;
    private List<Tour> cultureTours;
    private List<Tour> shoppingTours;
    private List<Tour> wellnessTours;
    private List<Tour> allTours;

    /**
     * Constructor
     *
     * Here we initialise controller instance,
     * and call DataSource class
     * to initialise collections of tours.
     *
     * If exception occurs, collections initialises as empty ones
     */
    public AgencyModel() {
        controller = new Controller();

        View.print(Messages.GRITTING);

        try {
            cruiseTours = DataSource.getCruiseTours();
        } catch (JAXBException e) {
            cruiseTours = new ArrayList<>();
        }

        try {
            cultureTours = DataSource.getCultureTours();
        } catch (JAXBException e) {
            cultureTours = new ArrayList<>();
        }

        try {
            shoppingTours = DataSource.getShoppingTours();
        } catch (JAXBException e) {
            shoppingTours = new ArrayList<>();
        }

        try {
            wellnessTours = DataSource.getWellnessTours();
        } catch (JAXBException e) {
            wellnessTours = new ArrayList<>();
        }

        allTours = new ArrayList<>();

        allTours.addAll(cruiseTours);
        allTours.addAll(cultureTours);
        allTours.addAll(shoppingTours);
        allTours.addAll(wellnessTours);

        mainMenu();
    }

    /*
     * Method to get instances of CruiseTour class
     * (all cruise tours)
     */
    private List<Tour> getCruiseTours() {
        return cruiseTours;
    }

    /*
     * Method to get instances of CultureTour class
     * (all culture tours)
     */
    private List<Tour> getCultureTours() {
        return cultureTours;
    }

    /*
     * Method to get instances of ShoppingTour class
     * (all shopping tours)
     */
    private List<Tour> getShoppingTours() {
        return shoppingTours;
    }

    /*
     * Method to get instances of WellnessTour class
     * (all wellness tours)
     */
    private List<Tour> getWellnessTours() {
        return wellnessTours;
    }

    /*
     * Method to get all available tours
     */
    private List<Tour> getAll() {
        return allTours;
    }

    /*
     * Switch to deal with user command in context menu
     */
    private void executeContextMenuCommand(List<Tour> tours) {

        int command = controller.getCommand();

        switch (command) {
            case 1:
                tours.sort(Comparators.MAX_PRICE);
                contextMenu(tours);
                break;
            case 2:
                tours.sort(Comparators.MIN_PRICE);
                contextMenu(tours);
                break;
            case 3:
                tours.sort(Comparators.MORE_DAYS);
                contextMenu(tours);
                break;
            case 4:
                tours.sort(Comparators.FEWER_DAYS);
                contextMenu(tours);
                break;
            case 0:
                mainMenu();
                break;
            default:
                View.print(Messages.COMMAND_NOT_RECOGNIZED);
                executeContextMenuCommand(tours);
        }
    }

    /*
     * Switch to deal with user command in main menu
     */
    private void executeMainMenuCommand() {

        int command = controller.getCommand();

        switch (command) {
            case 1:
                contextMenu(getCruiseTours());
                break;
            case 2:
                contextMenu(getCultureTours());
                break;
            case 3:
                contextMenu(getShoppingTours());
                break;
            case 4:
                contextMenu(getWellnessTours());
                break;
            case 5:
                contextMenu(getAll());
                break;
            default:
                View.print(Messages.COMMAND_NOT_RECOGNIZED);
                executeMainMenuCommand();
        }
    }

    /*
     * Shows main menu and prompts user to input command in numeric format
     */
    private void mainMenu() {
        View.print(Messages.START_MENU);

        executeMainMenuCommand();
    }

    /*
     * Shows main menu and prompts user to input command in numeric format
     */
    private void contextMenu(List<Tour> tours) {
        View.printTours(tours);
        View.print(Messages.FOOTER);

        executeContextMenuCommand(tours);
    }
}
