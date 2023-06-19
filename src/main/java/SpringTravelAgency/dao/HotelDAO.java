package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Hotel;
import java.util.List;

public interface HotelDAO {

    Hotel getHotelAllConnectionsById(Long theId);

    List<Hotel> getHotelList();

    Hotel findHotelById(Long theId);

    Hotel findHotelByName(String hotelName);

    List<Hotel> findHotelByCountry(String country);

    void addHotel(Hotel theHotel);

    void updateHotel(Hotel theHotel);

    void deleteHotelById(Long theHotel);
}
