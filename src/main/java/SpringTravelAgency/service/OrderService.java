package SpringTravelAgency.service;

import SpringTravelAgency.entity.Order;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    List<Order> getOrderList();

    List<Order> getFreeRoomList(LocalDate localDate);

    Order findOrderById(Long theId);

    List<Order> getAllUserOrders(Long userId);

    void addOrder(Order theOrder);

    void updateOrder(Order theOrder);

    void deleteOrder(Long roomId, LocalDate arrive, LocalDate departure);
}
