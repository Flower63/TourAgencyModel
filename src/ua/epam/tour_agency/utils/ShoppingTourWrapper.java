package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.ShoppingTour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Dennis
 *
 * on 11/1/2015.
 */
@XmlRootElement(name = "tours")
public class ShoppingTourWrapper {
    private List<ShoppingTour> tours;

    @XmlElement(name = "tour")
    public List<ShoppingTour> getTours() {
        return tours;
    }

    public void setTours(List<ShoppingTour> tours) {
        this.tours = tours;
    }
}
