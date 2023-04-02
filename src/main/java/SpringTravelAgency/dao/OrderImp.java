package SpringTravelAgency.dao;


import SpringTravelAgency.entity.Order;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository

public class OrderImp implements OrderDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findOrderById(Long theId){
        Order order = entityManager.find(Order.class, theId);
        return order;
    }

    @Override
    public List<Order> getOrderList(){

        Query queryGetOrders=entityManager.createQuery("SELECT o FROM Order o");
        List<Order> allOrder= queryGetOrders.getResultList();

        return allOrder;
    }
    @Override
    public List<Order> getFreeRoomList(LocalDate localDate){

        Query queryGetOrders=entityManager.createQuery("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.hotel  LEFT JOIN FETCH o.user  " +
                "LEFT JOIN FETCH o.room where o.dateOfArrive<>:searchDate");
        queryGetOrders.setParameter("searchDate",localDate);
        List<Order> allOrder= queryGetOrders.getResultList();

        return allOrder;
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
    public void deleteOrderById(Long theOrder){
        Order order=findOrderById(theOrder);
        entityManager.remove(order);
    }




}
