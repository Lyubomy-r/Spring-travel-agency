package SpringTravelAgency.service;

import SpringTravelAgency.entity.Room;
import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    Room getRoomAllConnections(Long theId);

    List<Room> getRoomListAllConnections();

    Room findRoomById(Long theId);

    Room findRoomByHotelName(String hotelName);

    List<Room> freeRoomList(Long theCountry, LocalDate arrivalDate,
                            LocalDate departureDate);

    List<Room> freeRoomListByName(String theCountry, LocalDate arrivalDate,
                                  LocalDate departureDate);

    List<Room> findRoomListByHotelId(Long hotelId);

    List<Room> getRoomList();

    Boolean roomExist( List<Room> roomList, Room theRoom);

    void addRoom(Room theRoom);

    void updateRoom(Room theRoom);

    void deleteRoomById(Long theRoom);
}
