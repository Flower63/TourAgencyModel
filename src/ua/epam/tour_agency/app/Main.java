package ua.epam.tour_agency.app;

import ua.epam.tour_agency.utils.DataSource;
import ua.epam.tour_agency.utils.DataSourceXml;

/**
 * This class contains main method
 * as entry point to application
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class Main {
    public static void main(String[] args) {
        DataSource source = new DataSourceXml();
        Agency agency = new Agency(source);
        Controller controller = new Controller(agency);
        controller.start();
    }
}
