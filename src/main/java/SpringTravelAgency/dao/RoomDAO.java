package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomDAO {

    public Room getRoomAllConnections(Long theId);
    public List<Room> getRoomListAllConnections();
    public Room findRoomById(Long theId);
    public List<Room> freeRoomList(LocalDate searchDate);
    public List<Room> getRoomList();
    public void addRoom(Room theRoom);
    public void updateRoom(Room theRoom);

    public void deleteRoomById(Long theRoom);

}
