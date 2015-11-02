package ua.epam.tour_agency.entity;

import ua.epam.tour_agency.data.TourFood;
import ua.epam.tour_agency.data.TourSubject;
import ua.epam.tour_agency.data.TourTransport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Base class that represents tour template.
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public class Tour {

    private TourSubject subject;
    private String country;
    private String town;
    private LocalDate startDate;
    private LocalDate endDate;
    private TourTransport transport;
    private TourFood food;
    private int price;

    /*
     * Instance of DataTimeFormatter.
     *
     * Needed to parse and format dates to String
     */
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

    /**
     * Constructor
     *
     * @param subject - type of tour
     * @param country - appropriate country
     * @param town - destination town
     * @param startDate - date of start
     * @param endDate - date of end
     * @param transport - transport type
     * @param food - food type
     * @param price - price of tour
     */
    public Tour(TourSubject subject, String country, String town, LocalDate startDate,
                LocalDate endDate, TourTransport transport, TourFood food,
                int price) {

        this.subject = subject;
        this.country = country;
        this.town = town;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transport = transport;
        this.food = food;
        this.price = price;
    }

    /**
     * Default empty constructor.
     *
     * Necessary for unmarshall objects.
     *
     * Creates tour without any data, to fill it by setters later
     */
    public Tour() {}

    public TourSubject getSubject() {
        return subject;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public String getStartDate() {
        return startDate.format(formatter);
    }

    public String getEndDate() {
        return endDate.format(formatter);
    }

    public TourTransport getTransport() {
        return transport;
    }

    public TourFood getFood() {
        return food;
    }

    public int getPrice() {
        return price;
    }

    public int getDays() {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    public void setSubject(TourSubject subject) {
        this.subject = subject;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate, formatter);
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate, formatter);
    }

    public void setTransport(TourTransport transport) {
        this.transport = transport;
    }

    public void setFood(TourFood food) {
        this.food = food;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
