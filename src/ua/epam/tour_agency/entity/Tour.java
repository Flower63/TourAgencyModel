package ua.epam.tour_agency.entity;

import ua.epam.tour_agency.data.Food;
import ua.epam.tour_agency.data.Transport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Base class that represents tour template.
 *
 * @author Dennis
 *
 * on 10/31/2015.
 */
public abstract class Tour {

    protected String country;
    protected String town;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected Transport transport;
    protected Food food;
    protected int price;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

    /**
     * Constructor
     *
     * @param country - appropriate country
     * @param town - destination town
     * @param startDate - date of start
     * @param endDate - date of end
     * @param transport - transport type
     * @param food - food type
     * @param price - price of tour
     */
    public Tour(String country, String town, LocalDate startDate,
                LocalDate endDate, Transport transport, Food food,
                int price) {

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
     */
    public Tour() {}

    /**
     * Getter
     *
     * @return tour's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter
     *
     * @return tour's town
     */
    public String getTown() {
        return town;
    }

    /**
     * Getter
     *
     * @return tour's start date
     */
    public String getStartDate() {
        return startDate.format(formatter);
    }

    /**
     * Getter
     *
     * @return tour's end date
     */
    public String getEndDate() {
        return endDate.format(formatter);
    }

    /**
     * Getter
     *
     * @return tour's transport type
     */
    public Transport getTransport() {
        return transport;
    }


    /**
     * Getter
     *
     * @return tour's food type
     */
    public Food getFood() {
        return food;
    }

    /**
     * Getter
     *
     * @return tour's price (in $)
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter
     *
     * @return tour's duration (in days)
     */
    public int getDays() {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param country - tour country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param town - tour town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param startDate - start of tour in dd.MM.yy format
     */
    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate, formatter);
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param endDate - end of tour in dd.MM.yy format
     */
    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate, formatter);
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param transport - type of transport
     */
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param food - type of food
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Setter. Required to unmarshall
     *
     * @param price price of entire tour. In $
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
