package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;


import javax.persistence.Query;
import javax.transaction.Transactional;

import SpringTravelAgency.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class OrderImp implements OrderInterface{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hotel> getRooms() {

        Query hotelQueue2= entityManager.createQuery("Select e from Hotel e");
        List <Hotel> findHotel = hotelQueue2.getResultList();

        return findHotel;
        }
    @Override
    public Hotel getHotel(Long theId) {
        Hotel findHotel=entityManager.find(Hotel.class,theId);
        return findHotel;
    }
    @Override
    public Room getRoom(Long theId) {
        Room findRoom=entityManager.find(Room.class,theId);

        return findRoom;
    }
        @Override
        public List<Room> freeRoomList(LocalDate searchDate){

        Query queryGetDateArrive=entityManager.createQuery("SELECT r FROM Room r");
            List<Room> allRoom= queryGetDateArrive.getResultList();

            return allRoom;
        }
        @Override
        public List<Room> RoomList(){

        Query queryGetDateArrive=entityManager.createQuery("SELECT r FROM Room r");
        List<Room> allRoom= queryGetDateArrive.getResultList();

        return allRoom;
    }
    @Override
    public void addRoom(Room theRoom){
        entityManager.persist(theRoom);
    }
    @Override
    public void addHotel(Hotel theHotel){
        entityManager.persist(theHotel);
    }
    @Override
    public void addUser(User theUser){
        entityManager.persist(theUser);
    }
    @Override
    public void addOrder(Order theOrder){
        entityManager.persist(theOrder);
    }







}
