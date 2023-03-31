package SpringTravelAgency.dao;


import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class HotelImp implements HotelDAO{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Hotel> getHotelList() {

        // Hotel findHotel = entityManager.find(Hotel.class, 1);
        // Query hotelQueue= entityManager.createQuery("Select h from Hotel h where h.hotelId=1 ");
        Query hotelQueue2= entityManager.createQuery("Select e from Hotel e");
        List <Hotel> findHotel = hotelQueue2.getResultList();

        return findHotel;
    }

    @Override
    public Hotel findHotelById(Long theId){
        Hotel hotel=entityManager.find(Hotel.class, theId);

        return hotel;
    }


    @Override
    public Hotel getHotelAllConnections(Long theId) {
        Query query = entityManager.createQuery("SELECT DISTINCT h FROM Hotel h LEFT join fetch h.rooms WHERE h.hotelId=:theId")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
        query.setParameter("theId",theId);
        Hotel findHotel= (Hotel) query.getSingleResult();

        Query query2 = entityManager.createQuery("SELECT DISTINCT h FROM Hotel h LEFT join fetch h.orderList WHERE h.hotelId=:theIdR")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
        query2.setParameter("theIdR",theId);
        findHotel= (Hotel) query2.getSingleResult();

        return findHotel;
    }

    @Override
    public void addHotel(Hotel theHotel){
        entityManager.persist(theHotel);
    }

    @Override
    public void updateHotel(Hotel theHotel){
        entityManager.merge(theHotel);
    }
    @Override
    public void deleteHotelById(Long theHotel){
        Hotel hotel=findHotelById(theHotel);
        entityManager.remove(hotel);
    }

}
