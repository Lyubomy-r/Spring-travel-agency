package SpringTravelAgency.service;

import SpringTravelAgency.dao.OrderDAO;
import SpringTravelAgency.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    private OrderDAO orderService;

    @Autowired
    public OrderServiceImp(OrderDAO orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }

    @Override
    public List<Order> getFreeRoomList(LocalDate localDate) {
        return orderService.getFreeRoomList(localDate);
    }

    @Override
    public Order findOrderById(Long theId) {
        return orderService.findOrderById(theId);
    }

    @Override
    public List<Order> getAllUserOrders(Long userId) {
        return orderService.getAllUserOrders(userId);
    }

    @Override
    public void addOrder(Order theOrder) {
        orderService.addOrder(theOrder);
    }

    @Override
    public void updateOrder(Order theOrder) {
        orderService.updateOrder(theOrder);
    }

    @Override
    public void deleteOrder(Long roomId, LocalDate arrive, LocalDate departure) {
        orderService.deleteOrder(roomId, arrive, departure);
    }
}
