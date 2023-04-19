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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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

<<<<<<< HEAD
   @Autowired
   public AppController (OrderService orderService, HotelService hotelService, RoomService roomService, UserService userService,PasswordEncoder passwordEncoder){
=======
<<<<<<< HEAD
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
=======
   @Autowired
   public AppController (OrderService orderService, HotelService hotelService, RoomService roomService,
                         UserService userService,PasswordEncoder passwordEncoder){
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
       this.orderService = orderService;
       this.hotelService = hotelService;
       this.roomService = roomService;
       this.userService = userService;
       this.passwordEncoder=passwordEncoder;
   }
<<<<<<< HEAD
=======
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)



    @RequestMapping("/freeHotel")
<<<<<<< HEAD
    public String freeHotel( @RequestParam("searchCountry")String hotelName,
=======
<<<<<<< HEAD
    public String freeHotel(@RequestParam("hotId") Long hotelId, @RequestParam("searchCountry")String hotelName,
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
                            @RequestParam ("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate myDate,
                            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate myDate1,
=======
    public String freeHotel( @RequestParam("searchCountry")String hotelName,
                            @RequestParam ("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate dateArrival,
                            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDeparture,
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
                            Model theModel){
        LocalDate arrival=LocalDate.now();

<<<<<<< HEAD
=======
<<<<<<< HEAD

        Hotel hotel=hotelService.findHotelById(hotelId);
        if(hotelName.equals(hotel.getNameHotel())){
            List<Room> rooms= roomService.freeRoomList( hotelId,myDate,myDate1);
            theModel.addAttribute("modelRooms", rooms);
        }else{
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
            List<Room> roomList= roomService.freeRoomListByName( hotelName,myDate,myDate1);
            theModel.addAttribute("modelRooms", roomList);

        theModel.addAttribute("arrivalDate", arrival);
        theModel.addAttribute("departureDate",departure);
=======
        try {
            if (dateArrival.isAfter(arrival) && dateDeparture.isAfter(dateArrival)) {

                List<Room> roomList = roomService.freeRoomListByName(hotelName, dateArrival, dateDeparture);
                theModel.addAttribute("modelRooms", roomList);
                theModel.addAttribute("arrivalDate", dateArrival);
                theModel.addAttribute("departureDate", dateDeparture);
            }else{

                throw new RuntimeException( "Write correct date arrive and departure !" );
            }
        }catch (Exception e){
            e.getMessage();
        }
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)

        return "list-room";
    }

<<<<<<< HEAD
    @RequestMapping("/showFormSearch")
    public String showFormSearch(@RequestParam("hotelId")Long hotelId, Model theModel){
            List<Hotel> hotelList= hotelService.getHotelList() ;
            Hotel hotelName=hotelService.findHotelById(hotelId);

        theModel.addAttribute("hotelName", hotelName);



        return "search-hotel";
    }
=======
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)

    @RequestMapping  ("/showHotelInCountry")
    public String showHotelInCountry(@RequestParam("searchCountry") String country, Model theModel){
       List<Hotel> hotelList=hotelService.findHotelByCountry(country);

        theModel.addAttribute("countryList",hotelList );
<<<<<<< HEAD
       return "free-hot";
=======
<<<<<<< HEAD
        return "index";
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
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


<<<<<<< HEAD
=======
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("userRegistration")User theUser) throws Exception {
        List<User> userList=userService.getUserList();
        Boolean emailExist = userList.stream().anyMatch(user->user.getEmail().equals(theUser.getEmail()));
        if(emailExist){
            throw new Exception(
                    "There is an account with that email adress:" + theUser.getEmail());
=======
       return "free-hotel";
    }

>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
    @GetMapping("/register")
    public String userRegister(Model theModel){
        User user = new User();
        theModel.addAttribute("userEntity", user);

        return "user-register";
    }
    //Encode the Password on Registration
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("userEntity") @Valid User theUser, BindingResult theBindingResult) throws Exception {

        if(theBindingResult.hasErrors()){
            return "user-register";
<<<<<<< HEAD
=======
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
        }
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
<<<<<<< HEAD
                           @RequestParam ("arrivalDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate myDate,
<<<<<<< HEAD
                           @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate myDate1,
                           Principal principal,Model theModel){
=======
                           @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate myDate1, Principal principal,Model theModel){
=======
                           @RequestParam ("arrivalDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate arrivalDate,
                           @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                           Principal principal,Model theModel) throws Exception {
        LocalDate dateNow=LocalDate.now();
        try {
       if(arrivalDate.isAfter(dateNow) && departureDate.isAfter(arrivalDate) ){
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)

        Room room= roomService.getRoomAllConnections(roomId);
        Hotel hotel=hotelService.getHotelAllConnections(room.getHotel().getHotelId());
        User user = userService.getUserByEmail(principal.getName());

        Order myOrder=new Order();

        myOrder.setDateOfArrive( arrivalDate);
        myOrder.setDepartureDate(departureDate);
        myOrder.addOrderToHotel(hotel);
        myOrder.addOrderToRoom(room);
        myOrder.addUserToOrder(user);
        orderService.addOrder(myOrder);
        theModel.addAttribute("userId", user.getUserId());
       }else{
           throw new Exception( "Write correct date arrive and departure !" );
       }
   } catch (Exception e) {
            e.getMessage();
        }

<<<<<<< HEAD

         theModel.addAttribute("userId", user.getUserId());
=======
<<<<<<< HEAD
        theModel.addAttribute("userId", user.getUserId());
=======
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)

        return "redirect:/api/showUserOrders";
    }

<<<<<<< HEAD
    @RequestMapping("/showOrder")
    public String showOrder(Model theModel){
        List<Order> orderList= orderService.getOrderList();

        theModel.addAttribute("orderList", orderList);
        return "order-list";
=======
    @GetMapping("/userName")//+
    public String userName(Principal principal, Model theModel){
        User user = userService.getUserByEmail(principal.getName());
        theModel.addAttribute("userId", user.getUserId());

        return "redirect:/api/showUserOrders";
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
    }
    @GetMapping("/userName")
    public String userName(Principal principal, Model theModel){
        User user = userService.getUserByEmail(principal.getName());
        theModel.addAttribute("userId", user.getUserId());

        return "redirect:/api/showUserOrders";
    }

    @GetMapping("/showUserOrders")
    public String showUserOrders(@ModelAttribute("userId") Long userId, Model theModel,Principal principal){

           List<Order> orderList = orderService.getAllUserOrders(userId);
           theModel.addAttribute("orderList", orderList);

        return "user-orders";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder( @RequestParam("roomId") Long roomId,
                               @RequestParam("arrivalDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrive,
                               @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departure,Principal principal, Model theModel ){
       orderService.deleteOrder(roomId, arrive, departure);
        User user = userService.getUserByEmail(principal.getName());
        theModel.addAttribute("userId", user.getUserId());

       return "redirect:/api/showUserOrders";

    }

}
