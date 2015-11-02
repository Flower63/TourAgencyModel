package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.Messages;
import ua.epam.tour_agency.entity.*;
import ua.epam.tour_agency.data.Comparators;
import ua.epam.tour_agency.utils.DataSource;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
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

    /*
     * Collections of different type tours
     */
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
     * Prompts user to input command in numeric format.
     *
     * Execute command for context menu if valid
     * or outputs warning message otherwise
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
     * Prompts user to input command in numeric format.
     *
     * Execute command for main menu if valid
     * or outputs warning message otherwise
     */
    private void executeMainMenuCommand() {

        int command = controller.getCommand();

        switch (command) {
            case 1:
                contextMenu(cruiseTours);
                break;
            case 2:
                contextMenu(cultureTours);
                break;
            case 3:
                contextMenu(shoppingTours);
                break;
            case 4:
                contextMenu(wellnessTours);
                break;
            case 5:
                contextMenu(allTours);
                break;
            default:
                View.print(Messages.COMMAND_NOT_RECOGNIZED);
                executeMainMenuCommand();
        }
    }

    /*
     * Shows main menu
     */
    private void mainMenu() {
        View.print(Messages.START_MENU);

        executeMainMenuCommand();
    }

    /*
     * Shows context menu
     */
    private void contextMenu(List<Tour> tours) {
        View.printTours(tours);
        View.print(Messages.FOOTER);

        executeContextMenuCommand(tours);
    }
}
