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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagementController {

    private HotelService hotelService;
    private RoomService roomService;
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public ManagementController(HotelService hotelService,RoomService roomService, UserService userService, OrderService orderService ){
        this.hotelService=hotelService;
        this.roomService=roomService;
        this.userService=userService;
        this.orderService=orderService;

    }

    @GetMapping("/showeAllHotels")
    public String  showeAllHotels(Model theModel){
        List<Hotel> hotelList=hotelService.getHotelList();
        theModel.addAttribute("hotel",hotelList);
        return "hotel-list";
    }
    @GetMapping("/addHotel")
    public String addHotel(Model theModel){
        Hotel hotel = new Hotel();

        theModel.addAttribute("hotel",hotel);

        return "hotel-form";
    }
    @GetMapping("/updateHotel")
    public String updateHotel(@RequestParam("hotelId")Long hotelId,Model theModel){
        Hotel hotel = hotelService.findHotelById(hotelId);

        theModel.addAttribute("hotel",hotel);

        return "hotel-form";
    }

    @PostMapping("/saveHotel")
    public String saveHotel(@ModelAttribute("hotel") Hotel theHotel ){

        hotelService.addHotel(theHotel);

        return "redirect:/api/showeAllHotels";
    }


    @GetMapping("/addRoom")
    public String addRoom(Model theModel){
        Room room = new Room();
        List<Hotel> hotelList=hotelService.getHotelList();
        theModel.addAttribute("room",room);
        theModel.addAttribute("nameHotel",hotelList);
        return "room-form";
    }

    @PostMapping ("/saveRoom")
    public String saveRoom(@RequestParam("hotelName")String hotelName, @ModelAttribute("room") Room theRoom) {

        Hotel hotel;
        if (hotelName.isEmpty()) {
            hotel = hotelService.findHotelByName(theRoom.getHotel().getNameHotel());
        } else {
            hotel = hotelService.findHotelByName(hotelName);
        }


        if (theRoom.getRoomId() == null) {
            theRoom.addHotelToRoom(hotel);
            roomService.addRoom(theRoom);
        } else {
            theRoom.addHotelToRoom(hotel);
            roomService.updateRoom(theRoom);
        }

        return "redirect:/management/showeAllHotels";
    }

    @PostMapping ("/updateRoom")
    public String updateRoom(@ModelAttribute("room") Room theRoom) {
        Hotel hotel=hotelService.findHotelByName(theRoom.getHotel().getNameHotel());
        theRoom.addHotelToRoom(hotel);
            roomService.updateRoom(theRoom);

        return "redirect:/management/showeAllHotels";
    }
    @GetMapping("/updateRoom")
    public String updateRoom(@RequestParam("roomId")Long hotelId,Model theModel){
        Room room = roomService.findRoomById(hotelId);
        Hotel hotel=room.getHotel();
        theModel.addAttribute("room",room);
        theModel.addAttribute("nameHotel",hotel);
        return "room-update-form";
    }

    @RequestMapping("/showHotelRooms")
    public String showHotelRooms(@RequestParam("hotelId")Long hotelId,  Model theModel){
        List<Room> roomList= roomService.findRoomListByHotelId(hotelId);

        theModel.addAttribute("modelRooms", roomList);

        return "hotel-rooms";
    }
    @GetMapping("/showUsers")
    public String showUsers(Model theModel){
        List<User> userList= userService.getUserList();

        theModel.addAttribute("userList", userList);
        return "user-list";
    }

    @GetMapping("/showUserOrders")
    public String showUserOrders(@RequestParam("userId") Long userId, Model theModel){
        List<Order> orderList= orderService.getAllUserOrders(userId);

        theModel.addAttribute("orderList", orderList);
        return "order-list";
    }

}
