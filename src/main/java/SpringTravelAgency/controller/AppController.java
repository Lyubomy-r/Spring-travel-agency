package SpringTravelAgency.controller;

import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import SpringTravelAgency.entity.User;
import SpringTravelAgency.entity.enumpack.Role;
import SpringTravelAgency.entity.enumpack.Status;
import SpringTravelAgency.service.HotelService;
import SpringTravelAgency.service.OrderService;
import SpringTravelAgency.service.RoomService;
import SpringTravelAgency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AppController (OrderService orderService, HotelService hotelService,
                          RoomService roomService, UserService userService,
                          PasswordEncoder passwordEncoder){
        this.orderService = orderService;
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.userService = userService;
        this.passwordEncoder=passwordEncoder;
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
    public String freeHotel(@RequestParam("hotId") Long hotelId, @RequestParam("searchCountry")String hotelName,
                            @RequestParam ("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate myDate,
                            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate myDate1,
                            Model theModel){
        LocalDate arrival=myDate;
        LocalDate departure=myDate1;


        Hotel hotel=hotelService.findHotelById(hotelId);
        if(hotelName.equals(hotel.getNameHotel())){
            List<Room> rooms= roomService.freeRoomList( hotelId,myDate,myDate1);
            theModel.addAttribute("modelRooms", rooms);
        }else{
            List<Room> roomList= roomService.freeRoomListByName( hotelName,myDate,myDate1);
            theModel.addAttribute("modelRooms", roomList);
        }
        theModel.addAttribute("arrivalDate", arrival);
        theModel.addAttribute("departureDate",departure);

        return "list-room";
    }

    @RequestMapping("/showFormSearch")
    public String showFormSearch(@RequestParam("hotelId")Long hotelId, Model theModel){
        List<Hotel> hotelList= hotelService.getHotelList() ;
        Hotel hotelName=hotelService.findHotelById(hotelId);

        theModel.addAttribute("hotelName", hotelName);



        return "search-hotel";
    }

    @RequestMapping  ("/showHotelInCountry")
    public String showHotelInCountry(@RequestParam("searchCountry") String country, Model theModel){
        List<Hotel> hotelList=hotelService.findHotelByCountry(country);

        theModel.addAttribute("countryList",hotelList );
        return "index";
    }

    @RequestMapping("/showRoom")
    public String showRoom(@RequestParam("hotelId")Long hotelId,  Model theModel){
        List<Room> roomList= roomService.findRoomListByHotelId(hotelId);

        theModel.addAttribute("modelRooms", roomList);

        return "list-room";
    }



    @RequestMapping("/showUser")
    public String showUser(Model theModel){
        List<User> userList= userService.getUserList();

        theModel.addAttribute("customers", userList);
        return "user-list";
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model theModel){
        User user=new User();
        theModel.addAttribute("userRegistration", user);
        return "registration-form";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("userRegistration")User theUser) throws Exception {
        List<User> userList=userService.getUserList();
        Boolean emailExist = userList.stream().anyMatch(user->user.getEmail().equals(theUser.getEmail()));
        if(emailExist){
            throw new Exception(
                    "There is an account with that email adress:" + theUser.getEmail());
        }

        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        theUser.setRole(Role.USER);
        theUser.setStatus(Status.ACTIVE);
        userService.addUser(theUser);
        return "redirect:/";
    }

    @RequestMapping ("/addOrder")
    public String addOrder(@RequestParam("roomId") Long roomId ,
                           @RequestParam ("arrivalDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate myDate,
                           @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate myDate1, Principal principal,Model theModel){

        Room room= roomService.getRoomAllConnections(roomId);
        Hotel hotel=hotelService.getHotelAllConnections(room.getHotel().getHotelId());
        User user = userService.getUserByEmail(principal.getName());

        Order myOrder=new Order();
        LocalDate dateArrive= myDate;
        LocalDate dateDeparture= myDate1;
        myOrder.setDateOfArrive( dateArrive);
        myOrder.setDepartureDate(dateDeparture);
        myOrder.addOrderToHotel(hotel);
        myOrder.addOrderToRoom(room);
        myOrder.addUserToOrder(user);
        orderService.addOrder(myOrder);

        theModel.addAttribute("userId", user.getUserId());

        return "redirect:/api/showUserOrders";
    }

    @RequestMapping("/showOrder")
    public String showOrder(Model theModel){
        List<Order> orderList= orderService.getOrderList();

        theModel.addAttribute("orderList", orderList);
        return "order-list";
    }

    @GetMapping("/showUserOrders")
    public String showUserOrders(@ModelAttribute("userId") Long userId, Model theModel){
        List<Order> orderList= orderService.getAllUserOrders(userId);

        theModel.addAttribute("orderList", orderList);
        return "user-orders";
    }

}
