package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.Messages;
import ua.epam.tour_agency.data.TourSubject;
import ua.epam.tour_agency.entity.*;
import ua.epam.tour_agency.data.Comparators;
import ua.epam.tour_agency.utils.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Layer class to work with logic and data
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class Agency {

    private Controller controller;
    private List<Tour> allTours;

    /**
     * Constructor
     *
     * Here we initialise controller instance,
     * and call DataSource class
     * to initialise collections of tours.
     *
     * After that runs main menu
     */
    public Agency() {
        controller = new Controller();

        View.print(Messages.GRITTING);

        allTours = DataSource.getTours();

        mainMenu();
    }

    /**
     * Filter method thad filters all tours with specified type
     * (e.g. CRUISE of CULTURE or so.)
     *
     * @param subject - specified type of tour
     * @return list of tours, which matches given type
     */
    private List<Tour> filter(TourSubject subject) {
        List<Tour> results = new ArrayList<>();

        for (Tour tour : allTours) {
            if (tour.getSubject() == subject) {
                results.add(tour);
            }
        }

        return results;
    }

    /**
     * Prompts user to input command in numeric format.
     *
     * Execute command for context menu if valid
     * or outputs warning message otherwise
     *
     * @param tours - list of tours after filtration
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

    /**
     * Prompts user to input command in numeric format.
     *
     * Execute command for main menu if valid
     * or outputs warning message otherwise
     */
    private void executeMainMenuCommand() {

        int command = controller.getCommand();

        switch (command) {
            case 1:
                contextMenu(filter(TourSubject.CRUISE));
                break;
            case 2:
                contextMenu(filter(TourSubject.CULTURE));
                break;
            case 3:
                contextMenu(filter(TourSubject.SHOPPING));
                break;
            case 4:
                contextMenu(filter(TourSubject.WELLNESS));
                break;
            case 5:
                contextMenu(allTours);
                break;
            default:
                View.print(Messages.COMMAND_NOT_RECOGNIZED);
                executeMainMenuCommand();
        }
    }

    /**
     * Shows main menu
     */
    private void mainMenu() {
        View.print(Messages.START_MENU);

        executeMainMenuCommand();
    }

    /**
     * Shows context menu
     */
    private void contextMenu(List<Tour> tours) {
        View.printTours(tours);
        View.print(Messages.FOOTER);

        executeContextMenuCommand(tours);
    }
}
