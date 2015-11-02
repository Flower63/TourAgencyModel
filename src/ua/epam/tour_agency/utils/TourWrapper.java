package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.Tour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Dennis
 *
 * on 11/2/2015.
 */
@XmlRootElement(name = "tours")
public class TourWrapper {
    private List<Tour> tours;

    @XmlElement(name = "tour")
    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
