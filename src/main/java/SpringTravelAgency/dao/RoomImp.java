package SpringTravelAgency.dao;

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
public class RoomImp implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Room findRoomById(Long theId) {
        Room room=entityManager.find(Room.class,theId);
        return room;
    }

    @Override
    public List<Room> freeRoomList(LocalDate searchDate){

        Query queryGetDateArrive=entityManager.createQuery("SELECT r FROM Room r");
        List<Room> allRoom= queryGetDateArrive.getResultList();
//            List<Room> orderList = allRoom.stream().map(a->{
//                                                            for(int i=0;i<a.getOrderList().size();i++){
//                                                                if(!(searchDate.equals(a.getOrderList().get(i).getDateOfArrive()))){
//                                                                    return a;
//                                                                }else{
//                                                                    a=null;
//                                                                    return a;
//                                                                }
//
//                                                            }
//                                                                 return a; }).toList();

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
