package SpringTravelAgency.dao;


import SpringTravelAgency.entity.Room;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository

public class RoomImp implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Room findRoomById(Long theId) {
        Room room=entityManager.find(Room.class,theId);
        return room;
    }

    @Override
    public Room findRoomByHotelName(String hotelName){

        Query hotetName=entityManager.createQuery("SELECT r FROM Room r  WHERE r.hotel.nameHotel=:Name")
                .setParameter("Name",hotelName).setHint(QueryHints.HINT_READONLY,true);
        Room room= (Room) hotetName.getSingleResult();
        return room;
    }
    @Override
    public List<Room> findRoomListByHotelId(Long hotelId){
        Query findRooms=entityManager.createQuery("SELECT r FROM Room r WHERE r.hotel.hotelId=:ID")
                .setParameter("ID",hotelId).setHint(QueryHints.HINT_READONLY,true);
        List<Room> roomList=findRooms.getResultList();
        return roomList;

    }

    @Override
    public List<Room> freeRoomList(String theCountry, LocalDate arrivalDate,
                                   LocalDate departureDate){

        Query queryGetDateArrive=entityManager.createQuery("SELECT r FROM Room r where r.hotel.country=:theCountry " +
                "and r.roomId not in (" +
                "SELECT O.room.roomId FROM Order O where :arrivalDate  BETWEEN O.dateOfArrive AND O.departureDate" +
                " OR :departureDate BETWEEN O.dateOfArrive AND O.departureDate OR O.dateOfArrive Between :arrivalDate and :departureDate" +
                " OR O.departureDate Between :arrivalDate and :departureDate)" );
        queryGetDateArrive.setParameter("theCountry", theCountry);
        queryGetDateArrive.setParameter("arrivalDate", arrivalDate);
        queryGetDateArrive.setParameter("departureDate", departureDate);

        List<Room> allRoom= queryGetDateArrive.getResultList();

        return allRoom;
    }
    @Override
    public List<Room> getRoomList(){

        Query queryGetDateArrive=entityManager.createQuery("SELECT r FROM Room r");
        List<Room> allRoom= queryGetDateArrive.getResultList();

        return allRoom;
    }
    @Override
    public List<Room> getRoomListAllConnections() {
        Query query = entityManager.createQuery("SELECT DISTINCT r FROM Room r LEFT join fetch r.orderList")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false );
        List<Room> findRoom=query.getResultList();
        Query query2 = entityManager.createQuery("SELECT DISTINCT r FROM Room r LEFT join fetch r.hotel WHERE r IN:findRoom")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false );
        query2.setParameter("findRoom", findRoom);
        findRoom=query2.getResultList();

        return findRoom;
    }

    @Override
    public Room getRoomAllConnections(Long theId) {
        Query query = entityManager.createQuery("SELECT DISTINCT r FROM Room r LEFT join fetch r.orderList WHERE r.roomId=:theId")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false );
        query.setParameter("theId", theId);
        Room findRoom= (Room) query.getSingleResult();
        Query query2 = entityManager.createQuery("SELECT DISTINCT r FROM Room r LEFT join fetch r.hotel WHERE r.roomId=:theIdR")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false );
        query2.setParameter("theIdR", theId);
        findRoom=(Room) query2.getSingleResult();

        return findRoom;
    }

    @Override
    public void addRoom(Room theRoom){
        entityManager.persist(theRoom);
    }

    @Override
    public void updateRoom(Room theRoom){
        entityManager.merge(theRoom);
    }
    @Override
    public void deleteRoomById(Long theRoom){
        Room room=findRoomById(theRoom);
        entityManager.remove(room);
    }


}