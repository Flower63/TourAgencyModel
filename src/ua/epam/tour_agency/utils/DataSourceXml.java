package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Data source class
 * to unmarshall tour data
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class DataSourceXml implements DataSource {

    /**
     * Method to find and unmarshall tour data.
     *
     * It looking up for list_of_tours.xml file
     * in XMLs directory
     *
     * @return list of available tours. If something goes wrong - returns empty list
     */
    public List<Tour> getTours() {
        try {
            JAXBContext context = JAXBContext.newInstance(TourWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            TourWrapper wrapper = (TourWrapper) unmarshaller.unmarshal(new File("XMLs/list_of_tours.xml"));
            return wrapper.getTours();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }
}
