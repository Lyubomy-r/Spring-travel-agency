package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface HotelDAO {

    public Hotel getHotelAllConnections(Long theId);
    public List<Hotel> getHotelList();
    public Hotel findHotelById(Long theId);
    public void addHotel(Hotel theHotel);
    public void updateHotel(Hotel theHotel);
    public void deleteHotelById(Long theHotel);
}
