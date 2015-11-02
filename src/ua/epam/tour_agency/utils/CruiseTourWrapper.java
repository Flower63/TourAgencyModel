package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.CruiseTour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Dennis
 *
 * on 11/1/2015.
 */
@XmlRootElement(name = "tours")
public class CruiseTourWrapper {
    private List<CruiseTour> tours;

    @XmlElement(name = "tour")
    public List<CruiseTour> getTours() {
        return tours;
    }

    public void setTours(List<CruiseTour> tours) {
        this.tours = tours;
    }
}
