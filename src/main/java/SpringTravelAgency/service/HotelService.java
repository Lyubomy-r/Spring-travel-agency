package SpringTravelAgency.service;

import SpringTravelAgency.entity.Hotel;
import java.util.List;
import java.util.Set;

public interface HotelService {

    Hotel getHotelAllConnections(Long theId);

    List<Hotel> getHotelList();

    Set<String> getCountryList();

    Hotel findHotelById(Long theId);

    Hotel findHotelByName(String hotelName);

    List<Hotel> findHotelByCountry(String country);

    void addHotel(Hotel theHotel);

    void updateHotel(Hotel theHotel);

    void deleteHotelById(Long theHotel);
}
