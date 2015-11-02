package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Data source class
 * to unmarshall tour data
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class DataSource {

    public static List<Tour> getCruiseTours() throws JAXBException {
        CruiseTourWrapper wrapper;

        JAXBContext context = JAXBContext.newInstance(CruiseTourWrapper.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        wrapper = (CruiseTourWrapper) unmarshaller.unmarshal(new File("XMLs/CruiseTours.xml"));

        return (List) wrapper.getTours();
    }

    public static List<Tour> getCultureTours() throws JAXBException {
        CultureTourWrapper wrapper;

        JAXBContext context = JAXBContext.newInstance(CultureTourWrapper.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        wrapper = (CultureTourWrapper) unmarshaller.unmarshal(new File("XMLs/CultureTours.xml"));

        return (List) wrapper.getTours();
    }

    public static List<Tour> getShoppingTours() throws JAXBException {
        ShoppingTourWrapper wrapper;

        JAXBContext context = JAXBContext.newInstance(ShoppingTourWrapper.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        wrapper = (ShoppingTourWrapper) unmarshaller.unmarshal(new File("XMLs/ShoppingTours.xml"));

        return (List) wrapper.getTours();
    }

    public static List<Tour> getWellnessTours() throws JAXBException {
        WellnessTourWrapper wrapper;

        JAXBContext context = JAXBContext.newInstance(WellnessTourWrapper.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        wrapper = (WellnessTourWrapper) unmarshaller.unmarshal(new File("XMLs/WellnessTours.xml"));

        return (List) wrapper.getTours();
    }
}
