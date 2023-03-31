package SpringTravelAgency.dao;

import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {

    public List<Order> getOrderList();
    public List<Order> getFreeRoomList(LocalDate localDate);
    public Order findOrderById(Long theId);
    public void addOrder(Order theOrder);
    public void updateOrder(Order theOrder);
    public void deleteOrderById(Long theOrder);
}
