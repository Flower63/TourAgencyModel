package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.CultureTour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Dennis
 *
 * on 11/1/2015.
 */
@XmlRootElement(name = "tours")
public class CultureTourWrapper {
    private List<CultureTour> tours;

    @XmlElement(name = "tour")
    public List<CultureTour> getTours() {
        return tours;
    }

    public void setTours(List<CultureTour> tours) {
        this.tours = tours;
    }
}
