package SpringTravelAgency.service;

import SpringTravelAgency.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    public List<Order> getOrderList();
    public List<Order> getFreeRoomList(LocalDate localDate);
    public Order findOrderById(Long theId);
    public void addOrder(Order theOrder);
    public void updateOrder(Order theOrder);
    public void deleteOrderById(Long theOrder);
}