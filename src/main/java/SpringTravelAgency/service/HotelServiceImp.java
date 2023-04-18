package SpringTravelAgency.service;

import SpringTravelAgency.dao.HotelDAO;
import SpringTravelAgency.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImp implements HotelService {

    private HotelDAO hotelDAO;

    @Autowired
    HotelServiceImp( HotelDAO hotelDAO ){
        this.hotelDAO=hotelDAO;
    }

    @Override
    public Hotel getHotelAllConnections(Long theId){
        return hotelDAO.getHotelAllConnectionsById(theId);
    }
    @Override
    public List<Hotel> getHotelList(){
      return  hotelDAO.getHotelList();
    }

    @Override
    public Hotel findHotelById(Long theId){
        return hotelDAO.findHotelById(theId);
    }

    @Override
    public Hotel findHotelByName(String hotelName){
        return hotelDAO.findHotelByName(hotelName);
    }
    @Override
    public List<Hotel> findHotelByCountry(String country){
        return hotelDAO.findHotelByCountry(country);
    }
    @Override
    public void addHotel(Hotel theHotel){
        hotelDAO.addHotel(theHotel);
    }
    @Override
    public void updateHotel(Hotel theHotel){
        hotelDAO.updateHotel(theHotel);
    }
    @Override
    public void deleteHotelById(Long theHotel){
        hotelDAO.deleteHotelById(theHotel);
    }




}
