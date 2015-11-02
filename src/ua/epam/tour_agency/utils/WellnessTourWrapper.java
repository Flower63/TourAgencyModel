package ua.epam.tour_agency.utils;

import ua.epam.tour_agency.entity.WellnessTour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Dennis
 *
 * on 11/1/2015.
 */
@XmlRootElement(name = "tours")
public class WellnessTourWrapper {
    private List<WellnessTour> tours;

    @XmlElement(name = "tour")
    public List<WellnessTour> getTours() {
        return tours;
    }

    public void setTours(List<WellnessTour> tours) {
        this.tours = tours;
    }
}
