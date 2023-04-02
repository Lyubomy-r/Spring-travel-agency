package SpringTravelAgency.service;

import SpringTravelAgency.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    public Room getRoomAllConnections(Long theId);
    public List<Room> getRoomListAllConnections();
    public Room findRoomById(Long theId);
    public List<Room> freeRoomList(String theCountry, LocalDate arrivalDate,
                                   LocalDate departureDate);
    public List<Room> getRoomList();
    public void addRoom(Room theRoom);
    public void updateRoom(Room theRoom);

    public void deleteRoomById(Long theRoom);
}
