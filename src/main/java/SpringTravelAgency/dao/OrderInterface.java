package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import SpringTravelAgency.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface OrderInterface {

    public List<Hotel> getRooms();
    public Hotel getHotel(Long theId);
    public Room getRoom(Long theId);
    public List<Room> freeRoomList(LocalDate searchDate);
    public List<Room> RoomList();

    public void addRoom(Room theRoom);
    public void addHotel(Hotel theHotel);
    public void addUser(User theUser);

    public void addOrder(Order theOrder);
}
