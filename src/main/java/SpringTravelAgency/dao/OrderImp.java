package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Order;
import javax.persistence.Query;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderImp implements OrderDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findOrderById(Long theId){
        Order order = entityManager.find(Order.class, theId);
        return order;
    }

    @Override
    public List<Order> getOrderList(){

        Query queryGetOrders=entityManager.createQuery("SELECT o FROM Order o").setHint(QueryHints.HINT_READONLY,true);
        List<Order> allOrder= queryGetOrders.getResultList();

        return allOrder;
    }
    @Override
    public List<Order> getFreeRoomList(LocalDate localDate){

        Query queryGetOrders=entityManager.createQuery("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.hotel  LEFT JOIN FETCH o.user  " +
                "LEFT JOIN FETCH o.room where o.dateOfArrive<>:searchDate").setHint(QueryHints.HINT_READONLY,true);
        queryGetOrders.setParameter("searchDate",localDate);
        List<Order> allOrder= queryGetOrders.getResultList();

        return allOrder;
    }
    @Override
    public List<Order> getAllUserOrders(Long userId){
        Query query= entityManager.createQuery(" SELECT o FROM Order o LEFT JOIN FETCH o.user WHERE o.user.userId=: userId ")
                        .setParameter("userId", userId).setHint(QueryHints.HINT_READONLY,true);
        List<Order> userOrdersList=query.getResultList();
        return userOrdersList;
    }
    @Override
    public void addOrder(Order theOrder){
        entityManager.persist(theOrder);
    }
    @Override
    public void updateOrder(Order theOrder){
        entityManager.merge(theOrder);
    }

    @Override
    public void deleteOrder(Long roomId, LocalDate arrive, LocalDate departure){
        Query query=entityManager.createQuery("SELECT o FROM Order o WHERE o.room.roomId=:deletId " +
                "and o.dateOfArrive=:dateArrive " +
                "and o.departureDate=:dateDeparture");
        query.setParameter("deletId",roomId)
                .setParameter("dateArrive",arrive)
                .setParameter("dateDeparture",departure);
        Order order=(Order) query.getSingleResult();
        entityManager.remove(order);
    }




}
