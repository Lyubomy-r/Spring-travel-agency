package SpringTravelAgency.controller;

import SpringTravelAgency.dao.*;
import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import SpringTravelAgency.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.LocalDate;

import java.util.List;


@Controller
@RequestMapping("/api")
public class AppController {

    private OrderDAO orderDAO;

    private HotelDAO hotelDAO;

    private RoomDAO roomDAO;

    private UserDAO userDAO;


    @Autowired
    public AppController ( OrderDAO orderDAO, HotelDAO hotelDAO, RoomDAO roomDAO,  UserDAO userDAO){
        this.orderDAO=orderDAO;
        this.hotelDAO=hotelDAO;
        this.roomDAO=roomDAO;
        this.userDAO=userDAO;
    }

    @RequestMapping("/form")
    public String homePage(){
        return "forn";
    }

    @GetMapping("/showHotel")
    public String getHotel(Model theModel){

        List<Hotel> roomList=hotelDAO.getHotelList();
        theModel.addAttribute("customers", roomList);
        List<Room> roomList1 = roomList.get(0).getRooms();

        theModel.addAttribute("roomList", roomList1);

        return "form-list";
    }
    @RequestMapping("/freeHotel")
    public String freeHotel(Model theModel){
        LocalDate myDate=LocalDate.of(2023,04,03);
        List<Room> rooms=roomDAO.getRoomListAllConnections();

        theModel.addAttribute("customers", rooms);
        return "list-room";
    }

    @RequestMapping("/addHotel")
    public String addHotel(Model theModel){
        Hotel hotel=new Hotel();

        hotel.setNameHotel("NewImp");
        hotel.setDescription("Best hotel in Maiymi");
        hotel.setCountry("Conect");
        hotel.setCity("Island Connect");
        hotelDAO.addHotel(hotel);

        theModel.addAttribute("customers", hotel);
        return "redirect:/api/showRoom";
    }

    @RequestMapping ("/addRoom")
    public String addRoom(Model theModel){
        Hotel hotel=hotelDAO.getHotelAllConnections(6L);
        Room room=new Room();

        room.setNumberRoom(7);
        room.setType("DOUBLE");
        room.setPrice(2400.00);
        room.addHotelToRoom(hotel);
        roomDAO.addRoom(room);

        return"redirect:/api/showRoom";
    }

    @RequestMapping ("/updateRoom")
    public String updateRoom(Model theModel){
        Hotel hotel=hotelDAO.getHotelAllConnections(1L);
        Room room=roomDAO.getRoomAllConnections(3L);

        room.setNumberRoom(10);
        room.setType("SINGEl");
        room.setPrice(3500.00);
        room.addHotelToRoom(hotel);
        roomDAO.updateRoom(room);


        return"redirect:/api/showRoom";
    }
    @RequestMapping("/showRoom")
    public String showRoom(Model theModel){
        List<Room> roomList=roomDAO.getRoomList();

        theModel.addAttribute("customers", roomList);

        return "list-room";
    }

    @RequestMapping ("/addUser")
    public String addUser(Model theModel){

        User user=new User();

        user.setFirstName("NewFer");
        user.setLastName("Kuler");
        user.setEmail("new@code.com");
        user.setPassword("456");

        userDAO.addUser(user);

        return"redirect:/api/showUser";
    }

    @RequestMapping("/showUser")
    public String showUser(Model theModel){
        List<User> userList=userDAO.getUserList();

        theModel.addAttribute("customers", userList);
        return "user-list";
    }

    @RequestMapping ("/addOrder")
    public String addOrder(Model theModel){


        Room room=roomDAO.getRoomAllConnections(10L);
        Hotel hotel1=hotelDAO.getHotelAllConnections(6L);
        User user=userDAO.getUserAllConnections(7L);
        Order myOrder=new Order();
        LocalDate dateArrive= LocalDate.now().plusMonths(2);
        LocalDate dateDeparture= LocalDate.now().plusMonths(2).plusDays(1);

        myOrder.setDateOfArrive( dateArrive);
        myOrder.setDepartureDate(dateDeparture);
        myOrder.addOrderToHotel(hotel1);
        myOrder.addOrderToRoom(room);
        myOrder.addUserToOrder(user);
        orderDAO.addOrder(myOrder);

        return"redirect:/api/showOrder";
    }

    @RequestMapping("/showOrder")
    public String showOrder(Model theModel){
        List<Order> orderList=orderDAO.getOrderList();

        theModel.addAttribute("customers", orderList);
        return "order-list";
    }

    @RequestMapping("/freeOrder")
    public String showFreeOrder(Model theModel){
        LocalDate myDate=LocalDate.of(2023,04,27);
        List<Order> orderList=orderDAO.getFreeRoomList(myDate);

        theModel.addAttribute("customers", orderList);
        return "free-hotel";
    }

}
