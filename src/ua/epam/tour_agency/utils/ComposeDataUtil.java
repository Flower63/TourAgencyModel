package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.data.TourFood;
import ua.epam.tour_agency.data.TourSubject;
import ua.epam.tour_agency.data.TourTransport;
import ua.epam.tour_agency.entity.Tour;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Little util to compose some sample tours
 * and marshall it to XML format
 *
 * @author Dennis
 *
 * on 11/1/2015.
 */
public class ComposeDataUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
    static List<Tour> list = new ArrayList<>();

    /**
     * Main marshall method.
     *
     * @param tours - list of tours to marshall
     * @param fileName - output file name
     * @throws Exception - just in case...
     */
    public static void write(List<Tour> tours, String fileName) throws Exception {
        JAXBContext context = JAXBContext.newInstance(TourWrapper.class);
        Marshaller marshaller = context.createMarshaller();

        TourWrapper instance = new TourWrapper();
        instance.setTours(tours);

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(instance, new File(fileName));
    }

    /**
     * Main method. Run here
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Subject: CRUISE, CULTURE, SHOPPING, WELLNESS");
            TourSubject subject = TourSubject.valueOf(reader.readLine());

            System.out.println("Country:");
            String country = reader.readLine();

            System.out.println("Town:");
            String town = reader.readLine();

            System.out.println("Start date in dd.MM.yy format:");
            LocalDate startDate = LocalDate.parse(reader.readLine(), formatter);

            System.out.println("End date in dd.MM.yy format:");
            LocalDate endDate = LocalDate.parse(reader.readLine(), formatter);

            System.out.println("Transport: PLANE, BUS, TRAIN, SHIP:");
            TourTransport transport = TourTransport.valueOf(reader.readLine());

            System.out.println("Food: BREAKFAST, LUNCH, ALL_INCLUSIVE, NONE:");
            TourFood food = TourFood.valueOf(reader.readLine());

            System.out.println("Price in $:");
            int price = Integer.parseInt(reader.readLine());

            list.add(new Tour(subject, country, town, startDate, endDate, transport, food, price));

            System.out.println("Create another tour? y/n");
            if (!reader.readLine().equals("y")) {
                break;
            }
        }

        String filename = "XMLs/file.xml";

        write(list, filename);
    }
}
