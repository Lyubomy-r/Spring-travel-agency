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

    private final OrderService orderService;

    private final HotelService hotelService;

    private final RoomService roomService;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppController(OrderService orderService, HotelService hotelService,
                         RoomService roomService, UserService userService,
                         PasswordEncoder passwordEncoder) {
        this.orderService = orderService;
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/freeHotel")
    public String freeHotel(@RequestParam("searchCountry") String hotelName,
                            @RequestParam("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateArrival,
                            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDeparture,
                            Model theModel) {
        LocalDate arrival = LocalDate.now();

        try {
            if (dateArrival.isAfter(arrival) && dateDeparture.isAfter(dateArrival)) {

                List<Room> roomList = roomService.freeRoomListByName(hotelName, dateArrival, dateDeparture);
                theModel.addAttribute("modelRooms", roomList);

                theModel.addAttribute("arrivalDate", dateArrival);
                theModel.addAttribute("departureDate", dateDeparture);
            } else {
                throw new RuntimeException("Write correct date arrive and departure !");
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return "list-room";
    }

    @RequestMapping("/showHotelInCountry")
    public String showHotelInCountry(@RequestParam("searchCountry") String country, Model theModel) {
        List<Hotel> hotelList = hotelService.findHotelByCountry(country);

        theModel.addAttribute("countryList", hotelList);
        return "free-hotel";
    }

    @GetMapping("/register")
    public String userRegister(Model theModel) {
        User user = new User();
        theModel.addAttribute("userEntity", user);

        return "user-register";
    }

    //Encode the Password on Registration
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("userEntity") @Valid User theUser,
                           BindingResult theBindingResult) throws Exception {

        if (theBindingResult.hasErrors()) {
            return "user-register";
        }
        List<User> userList = userService.getUserList();
        Boolean emailExist = userService.emailExist(userList, theUser);
        if (emailExist) {
            throw new Exception(
                    "There is an account with that email adress:" + theUser.getEmail());
        }

        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        theUser.setRole(Role.USER);
        theUser.setStatus(Status.ACTIVE);
        userService.addUser(theUser);

        return "redirect:/";
    }

    @RequestMapping("/addOrder")
    public String addOrder(@RequestParam("roomId") Long roomId,
                           @RequestParam("arrivalDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
                           @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                           Principal principal, Model theModel) throws Exception {
        LocalDate dateNow = LocalDate.now();
        try {
            if (arrivalDate.isAfter(dateNow) && departureDate.isAfter(arrivalDate)) {

                Room room = roomService.getRoomAllConnections(roomId);
                Hotel hotel = hotelService.getHotelAllConnections(room.getHotel().getHotelId());
                User user = userService.getUserByEmail(principal.getName());

                Order myOrder = new Order();

                myOrder.setDateOfArrive(arrivalDate);
                myOrder.setDepartureDate(departureDate);
                myOrder.addOrderToHotel(hotel);
                myOrder.addOrderToRoom(room);
                myOrder.addUserToOrder(user);
                orderService.addOrder(myOrder);
                theModel.addAttribute("userId", user.getUserId());
            } else {
                throw new Exception("Write correct date arrive and departure !");
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return "redirect:/api/showUserOrders";
    }

    @GetMapping("/userName")
    public String userName(Principal principal, Model theModel) {
        User user = userService.getUserByEmail(principal.getName());
        theModel.addAttribute("userId", user.getUserId());

        return "redirect:/api/showUserOrders";
    }

    @GetMapping("/showUserOrders")
    public String showUserOrders(@ModelAttribute("userId") Long userId, Model theModel, Principal principal) {

        List<Order> orderList = orderService.getAllUserOrders(userId);
        theModel.addAttribute("orderList", orderList);

        return "user-orders";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("roomId") Long roomId,
                              @RequestParam("arrivalDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrive,
                              @RequestParam("departureDateSearch") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departure,
                              Principal principal, Model theModel) {
        orderService.deleteOrder(roomId, arrive, departure);
        User user = userService.getUserByEmail(principal.getName());
        theModel.addAttribute("userId", user.getUserId());

        return "redirect:/api/showUserOrders";

    }
}
