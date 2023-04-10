package SpringTravelAgency.service;

import SpringTravelAgency.entity.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel getHotelAllConnections(Long theId);
    public List<Hotel> getHotelList();
    public Hotel findHotelById(Long theId);
    public Hotel findHotelByName(String hotelName);
    public List<Hotel> findHotelByCountry(String country);
    public void addHotel(Hotel theHotel);
    public void updateHotel(Hotel theHotel);
    public void deleteHotelById(Long theHotel);
}
