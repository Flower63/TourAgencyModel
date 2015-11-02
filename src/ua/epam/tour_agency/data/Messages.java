package ua.epam.tour_agency.data;

/**
 * Interface to hold standard messages and menu forms
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public interface Messages {
    String GRITTING = "Welcome to agency \"Mandatory tourist\"";
    String START_MENU = "Please, consider options below:\n\n" +
                        "1. Show cruise tours\n" +
                        "2. Show culture tours\n" +
                        "3. Show shopping tours\n" +
                        "4. Show wellness tours\n" +
                        "5. Show all available\n" +
                        "\ntype \"exit\" to exit\n";
    String FOOTER = "\nSort results:\n" +
                    "1-max price; 2-min price; 3-more days; 4-fewer days; 0-back";
    String DIV = "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
    String GOODBYE = "Goodbye!";
    String WARNING = "Please, input only numbers to choose option or \"exit\" to quit.";
    String COMMAND_NOT_RECOGNIZED = "Command not found. Try again";
}
