package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Hotel;

import java.util.List;

public interface HotelDAO {

    public Hotel getHotelAllConnectionsById(Long theId);
    public List<Hotel> getHotelList();
    public Hotel findHotelById(Long theId);
    public Hotel findHotelByName(String hotelName);
    public void addHotel(Hotel theHotel);
    public void updateHotel(Hotel theHotel);
    public void deleteHotelById(Long theHotel);
}