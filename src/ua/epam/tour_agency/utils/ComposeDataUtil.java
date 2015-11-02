package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.data.Food;
import ua.epam.tour_agency.data.Transport;
import ua.epam.tour_agency.entity.*;

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
    static List list = new ArrayList<>();

    public static void write(List tours, String fileName) throws Exception {
        JAXBContext context = JAXBContext.newInstance(ShoppingTourWrapper.class);
        Marshaller marshaller = context.createMarshaller();

        ShoppingTourWrapper instance = new ShoppingTourWrapper();
        instance.setTours(tours);

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(instance, new File(fileName));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int choice;

        System.out.println("Choose tour type:");
        System.out.println("1: Cruise tour");
        System.out.println("2: Culture tour");
        System.out.println("3: Shopping tour");
        System.out.println("4: Wellness tour");

        choice = Integer.parseInt(reader.readLine());

        while (true) {
            System.out.println("Country:");
            String country = reader.readLine();

            System.out.println("Town:");
            String town = reader.readLine();

            System.out.println("Start date in dd.MM.yy format:");
            LocalDate startDate = LocalDate.parse(reader.readLine(), formatter);

            System.out.println("End date in dd.MM.yy format:");
            LocalDate endDate = LocalDate.parse(reader.readLine(), formatter);

            System.out.println("Transport: PLANE, BUS, TRAIN, SHIP:");
            Transport transport = Transport.valueOf(reader.readLine());

            System.out.println("Food: BREAKFAST, LUNCH, ALL_INCLUSIVE, NONE:");
            Food food = Food.valueOf(reader.readLine());

            System.out.println("Price in $:");
            int price = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    makeCruise(country, town, startDate, endDate, transport, food, price);
                    break;
                case 2:
                    makeCulture(country, town, startDate, endDate, transport, food, price);
                    break;
                case 3:
                    makeShopping(country, town, startDate, endDate, transport, food, price);
                    break;
                case 4:
                    makeWellness(country, town, startDate, endDate, transport, food, price);
                    break;
            }

            System.out.println("Create another tour? y/n");
            if (!reader.readLine().equals("y")) {
                break;
            }
        }

        String filename = "XMLs/file.xml";

        switch (choice) {
            case 1:
                filename = "XMLs/CruiseTours.xml";
                break;
            case 2:
                filename = "XMLs/CultureTours.xml";
                break;
            case 3:
                filename = "XMLs/ShoppingTours.xml";
                break;
            case 4:
                filename = "XMLs/WellnessTours.xml";
                break;
        }

        write(list, filename);
    }

    private static void makeWellness(String country, String town, LocalDate startDate,
                                     LocalDate endDate, Transport transport, Food food,
                                     int price) {
        list.add(new WellnessTour(country, town, startDate, endDate, transport, food, price));
    }

    private static void makeShopping(String country, String town, LocalDate startDate,
                                     LocalDate endDate, Transport transport, Food food,
                                     int price) {
        list.add(new ShoppingTour(country, town, startDate, endDate, transport, food, price));
    }

    private static void makeCulture(String country, String town, LocalDate startDate,
                                    LocalDate endDate, Transport transport, Food food,
                                    int price) {
        list.add(new CultureTour(country, town, startDate, endDate, transport, food, price));
    }

    private static void makeCruise(String country, String town, LocalDate startDate,
                                   LocalDate endDate, Transport transport, Food food,
                                   int price) {
        list.add(new CruiseTour(country, town, startDate, endDate, transport, food, price));
    }
}
