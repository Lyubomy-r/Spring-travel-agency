package SpringTravelAgency.dao;


import SpringTravelAgency.entity.Hotel;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HotelImp implements HotelDAO{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Hotel> getHotelList() {

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
    public Hotel findHotelByName(String hotelName){

        Query hotelByName=entityManager.createQuery("SELECT h FROM Hotel h Left JOIN FETCH h.rooms WHERE h.nameHotel=:Name")
                .setParameter("Name",hotelName).setHint(QueryHints.HINT_READONLY,true);
        Hotel hotel= (Hotel) hotelByName.getSingleResult();
        return hotel;
    }
    @Override
    public Hotel getHotelAllConnectionsById(Long theId) {
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
