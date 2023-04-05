package SpringTravelAgency.service;

import SpringTravelAgency.dao.RoomDAO;
import SpringTravelAgency.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomServiceImp implements RoomService{

    private RoomDAO roomDAO;
    @Autowired
    public RoomServiceImp(RoomDAO roomDAO){
        this.roomDAO=roomDAO;
    }
    @Override
    public Room getRoomAllConnections(Long theId){
        return roomDAO.getRoomAllConnections(theId);
    }
    @Override
    public List<Room> getRoomListAllConnections(){
        return roomDAO.getRoomListAllConnections();
    }
    @Override
    public Room findRoomById(Long theId){
        return roomDAO.findRoomById(theId);
    }
    @Override
    public Room findRoomByHotelName(String hotelName){
        return roomDAO.findRoomByHotelName(hotelName);
    }
    public List<Room> findRoomListByHotelId(Long hotelId){
        return roomDAO.findRoomListByHotelId(hotelId);
    }
    @Override
    public List<Room> freeRoomList(String theCountry, LocalDate arrivalDate, LocalDate departureDate){
        return roomDAO.freeRoomList(theCountry,arrivalDate,departureDate);
    }
    @Override
    public List<Room> getRoomList(){
        return roomDAO.getRoomList();
    }
    @Override
    public void addRoom(Room theRoom){
        roomDAO.addRoom(theRoom);
    }
    @Override
    public void updateRoom(Room theRoom){
        roomDAO.updateRoom(theRoom);
    }
    @Override
    public void deleteRoomById(Long theRoom){
        roomDAO.deleteRoomById(theRoom);
    }
}
