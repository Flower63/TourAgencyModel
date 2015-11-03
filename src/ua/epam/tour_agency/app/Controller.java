package ua.epam.tour_agency.app;

import ua.epam.tour_agency.data.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Controller class to receive and handle user inputs.
 *
 * Created by Dennis
 *
 * on 10/31/2015.
 */
public class Controller {

    /*
     * Reader instance
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Returns user inputs as a numeric commands.
     *
     * In case of non-numeric input - prints warning message.
     *
     * Also supports application close on "exit" command.
     *
     * @return user command
     */
    public int getCommand() {
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
}
