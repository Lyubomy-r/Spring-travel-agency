package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Room;


import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderImp implements OrderInterface{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hotel> getRooms() {

        // Hotel findHotel = entityManager.find(Hotel.class, 1);
        // Query hotelQueue= entityManager.createQuery("Select h from Hotel h where h.hotelId=1 ");
        Query hotelQueue2= entityManager.createQuery("Select e from Hotel e");
        List <Hotel> findHotel = hotelQueue2.getResultList();

        return findHotel;
        }
}
