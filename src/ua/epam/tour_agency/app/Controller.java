package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.Comparators;
import ua.epam.tour_agency.data.Messages;
import ua.epam.tour_agency.data.TourSubject;
import ua.epam.tour_agency.entity.Tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Controller class to receive and handle user inputs.
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class Controller {

    /**
     * Instance of model, Agency class
     */
    private Agency agency;

    /**
     * Reader instance
     */
    private BufferedReader reader;

    /**
     * Array of comparators
     */
    private Comparators[] comparators;

    /**
     * Array of tour subjects (tour types)
     */
    private TourSubject[] subjects;

    /**
     * Command to return to main menu from context menu
     */
    private final int RETURN_TO_MAIN_COMMAND = 0;

    /**
     * Constructor
     *
     * @param agency - Model instance to manage
     */
    public Controller(Agency agency) {
        this.agency = agency;
        reader = new BufferedReader(new InputStreamReader(System.in));
        comparators = Comparators.values();
        subjects = TourSubject.values();
    }

    /**
     * Starts entire application
     */
    public void start() {
        View.print(Messages.GRITTING);

        mainMenu();
    }

    /**
     * Returns user inputs as a numeric commands.
     *
     * In case of non-numeric input - prints warning message.
     *
     * Also supports application close on "exit" command.
     *
     * @return user command
     */
    private int getCommand() {
        String input;
        int command = 0;
        boolean isNumber = false;

        try {
            while (!isNumber) {
                input = reader.readLine();

                try {
                    command = Integer.parseInt(input);
                    isNumber = true;
                } catch (NumberFormatException e) {
                    if ("exit".equals(input)) {
                        View.print(Messages.GOODBYE);
                        System.exit(0);
                    } else {
                        View.print(Messages.WARNING);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return command;
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

    /**
     * Prompts user to input command in numeric format.
     *
     * Execute command for main menu if valid
     * or outputs warning message otherwise
     */
    private void executeMainMenuCommand() {

        int command = getCommand();

        if (command > 0 && command <= subjects.length) {
            command -= 1;
            contextMenu(agency.filter(subjects[command]));
        } else if (command == subjects.length + 1) {
            contextMenu(agency.getAllTours());
        } else {
            View.print(Messages.COMMAND_NOT_RECOGNIZED);
            executeMainMenuCommand();
        }
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

        int command = getCommand();

        if (command > 0 && command <= comparators.length) {
            command -= 1;
            agency.sort(tours, comparators[command].getComparator());
            contextMenu(tours);
        } else if (command == RETURN_TO_MAIN_COMMAND) {
            mainMenu();
        } else {
            View.print(Messages.COMMAND_NOT_RECOGNIZED);
            executeContextMenuCommand(tours);
        }
    }
}
