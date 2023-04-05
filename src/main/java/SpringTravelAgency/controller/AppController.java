package SpringTravelAgency.controller;



import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import SpringTravelAgency.entity.User;
import SpringTravelAgency.service.HotelService;
import SpringTravelAgency.service.OrderService;
import SpringTravelAgency.service.RoomService;
import SpringTravelAgency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AppController {

    private OrderService orderService;


    private HotelService hotelService;


    private RoomService roomService;

    private UserService userService;


    @Autowired
    public AppController (OrderService orderService, HotelService hotelService, RoomService roomService, UserService userService){
        this.orderService = orderService;
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.userService = userService;
    }

    @RequestMapping("/form")
    public String homePage(){
        return "forn";
    }

    @GetMapping("/showHotel")
    public String getHotel(Model theModel){

        List<Hotel> roomList= hotelService.getHotelList();
        theModel.addAttribute("customers", roomList);
        List<Room> roomList1 = roomList.get(0).getRooms();


        theModel.addAttribute("roomList", roomList1);

        return "form-list";
    }
    @RequestMapping("/freeHotel")
    public String freeHotel(@RequestParam("searchCountry")String country, @RequestParam ("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate myDate,
                            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate myDate1, Model theModel){

        List<Room> rooms= roomService.freeRoomList( country,myDate,myDate1);

        theModel.addAttribute("customers", rooms);
        return "list-room";
    }

    @RequestMapping("/showFormSearch")
    public String showFormSearch(Model theModel){
        List<Hotel> hotelList= hotelService.getHotelList() ;

        theModel.addAttribute("hotelList", hotelList);

        return "search-hotel";
    }

    @RequestMapping("/showRoom")
    public String showRoom(@RequestParam("hotelId")Long hotelId,  Model theModel){
        List<Room> roomList= roomService.findRoomListByHotelId(hotelId);

        theModel.addAttribute("modelRooms", roomList);

        return "list-room";
    }

    @RequestMapping ("/addUser")
    public String addUser(Model theModel){

        User user=new User();

        user.setFirstName("NewFer");
        user.setLastName("Kuler");
        user.setEmail("new@code.com");
        user.setPassword("456");

        userService.addUser(user);


        return"redirect:/api/showUser";
    }

    @RequestMapping("/showUser")
    public String showUser(Model theModel){
        List<User> userList= userService.getUserList();

        theModel.addAttribute("customers", userList);
        return "user-list";
    }

    @RequestMapping ("/addOrder")
    public String addOrder(@RequestParam("roomId") Long roomId , Model theModel,   Principal principal){

        Room room= roomService.getRoomAllConnections(roomId);
        Hotel hotel=room.getHotel();
        User user = userService.getUserAllConnectionsByName(principal.getName());

        Order myOrder=new Order();
        LocalDate dateArrive= LocalDate.now().plusMonths(2);
        LocalDate dateDeparture= LocalDate.now().plusMonths(2).plusDays(1);
        myOrder.setDateOfArrive( dateArrive);
        myOrder.setDepartureDate(dateDeparture);
        myOrder.addOrderToHotel(hotel);
        myOrder.addOrderToRoom(room);
        myOrder.addUserToOrder(user);
        orderService.addOrder(myOrder);


        return"redirect:/api/showOrder";
    }

    @RequestMapping("/showOrder")
    public String showOrder(Model theModel){
        List<Order> orderList= orderService.getOrderList();

        theModel.addAttribute("orderList", orderList);
        return "order-list";
    }

    @RequestMapping("/freeOrder")
    public String showFreeOrder(Model theModel){
        LocalDate myDate=LocalDate.of(2023,04,27);
        List<Order> orderList= orderService.getFreeRoomList(myDate);

        theModel.addAttribute("customers", orderList);
        return "free-hotel";
    }

}
