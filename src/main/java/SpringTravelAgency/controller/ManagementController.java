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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagementController {

    private HotelService hotelService;
    private RoomService roomService;
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public ManagementController(HotelService hotelService,RoomService roomService,
                                UserService userService, OrderService orderService ){
        this.hotelService=hotelService;
        this.roomService=roomService;
        this.userService=userService;
        this.orderService=orderService;

    }
    @GetMapping("/managerPage")
    public String  showManagerPage(Model theModel){
        List<Hotel> hotelList=hotelService.getHotelList();
        theModel.addAttribute("hotel",hotelList);
        return "manager-page";
    }

<<<<<<< HEAD

    @GetMapping("/showeAllHotels")
=======
<<<<<<< HEAD
    @GetMapping("/showAllHotels")
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
    public String  showeAllHotels(Model theModel){
        List<Hotel> hotelList=hotelService.getHotelList();
        theModel.addAttribute("hotel",hotelList);
        return "hotel-list";
    }
=======

>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
    @GetMapping("/addHotel")
    public String addHotel(Model theModel){
        Hotel hotel = new Hotel();

        theModel.addAttribute("hotel",hotel);

        return "hotel-form";
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======


>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
    @GetMapping("/updateHotel")
    @PreAuthorize("hasAuthority('developers:read')")
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)

    @GetMapping("/addddHotel")
    public String addddHotel(Model theModel){
        Hotel hotel = new Hotel();

        theModel.addAttribute("hotel",hotel);

        return "fornvalid";
    }
    @GetMapping("/updateHotel")
    public String updateHotel(@RequestParam("hotelId")Long hotelId,Model theModel){
        Hotel hotel = hotelService.findHotelById(hotelId);

        theModel.addAttribute("hotel",hotel);

        return "hotel-form";
    }

    @PostMapping("/saveHotel")
<<<<<<< HEAD
    public String saveHotel(@Valid @ModelAttribute("hotel") Hotel theHotel, BindingResult bindingResult){
=======
<<<<<<< HEAD
    public String saveHotel(@ModelAttribute("hotel") Hotel theHotel ){
=======
    public String saveHotel(@Valid @ModelAttribute("hotel") Hotel theHotel,
                            BindingResult bindingResult) throws Exception {
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)

        if(bindingResult.hasErrors()){
            return "hotel-form";
        }
<<<<<<< HEAD
=======
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)

        if(theHotel.getHotelId()==null){
            List<Hotel> userList=hotelService.getHotelList();
            Boolean emailExist = userList.stream().anyMatch(user->user.getNameHotel().equals(theHotel.getNameHotel()));
            if(emailExist){
                throw new Exception(
                        "There is an hotel with that name :" + theHotel.getNameHotel());
//
            }else {
                hotelService.addHotel(theHotel);
            }
        }else {
            hotelService.updateHotel(theHotel);
        }

<<<<<<< HEAD


//        theModel.addAttribute("customers", hotel);
        return "redirect:/management/managerPage";
=======
<<<<<<< HEAD
        return "redirect:/management/showAllHotels";
=======
        return "redirect:/management/managerPage";
    }
    @GetMapping("/deleteHotel")
    public String deleteHotel(@RequestParam("hotelId") Long hotelId){

        hotelService.deleteHotelById(hotelId);


        return "redirect:/management/managerPage";
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
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
    public String saveRoom(@RequestParam("hotelName")String hotelName,
                           @ModelAttribute("room") Room theRoom) throws Exception {

        Hotel hotel;
        if (hotelName.isEmpty()) {
            hotel = hotelService.findHotelByName(theRoom.getHotel().getNameHotel());
        } else {
            hotel = hotelService.findHotelByName(hotelName);
        }

<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
        List<Room> roomList=roomService.findRoomListByHotelId(theRoom.getHotel().getHotelId());
        Boolean roomExist = roomList.stream().anyMatch(room->room.getNumberRoom().equals(theRoom.getNumberRoom()));
        if(roomExist){
            throw new Exception(
                    "There is an room with that room number :" + theRoom.getNumberRoom());
        }

>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
        if (theRoom.getRoomId() == null) {
            theRoom.addHotelToRoom(hotel);
            roomService.addRoom(theRoom);
        } else {
            theRoom.addHotelToRoom(hotel);
            roomService.updateRoom(theRoom);
        }

        return "redirect:/management/managerPage";
    }

    @PostMapping ("/updateRoom")
    public String updateRoom(@ModelAttribute("room") Room theRoom, Model theModel) {
        Hotel hotel=hotelService.findHotelByName(theRoom.getHotel().getNameHotel());
        theRoom.addHotelToRoom(hotel);
            roomService.updateRoom(theRoom);

        theModel.addAttribute("hotelId",hotel.getHotelId() );

        return "redirect:/management/showHotelRooms";
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

    @GetMapping("/deleteRoom")
    public String deleteRoom(@RequestParam("roomId") Long roomId,Model theModel){
        Room room= roomService.getRoomAllConnections(roomId);
        roomService.deleteRoomById(roomId);

        theModel.addAttribute("hotelId",  room.getHotel().getHotelId());
        return "redirect:/management/showHotelRooms";
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

<<<<<<< HEAD
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long userId){

=======
<<<<<<< HEAD
=======
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long userId){


>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
        userService.deleteUserById(userId);

        return "redirect:/management/showUsers";


    }

    @GetMapping("/userBanned")
    public String userBanned(@RequestParam("userId") Long userId){

        userService.bannedUser(userId);

        return "redirect:/management/showUsers";
    }

<<<<<<< HEAD
=======
>>>>>>> 35a4fdb ( added new jsp files, new view pages Manage, Home page , Login, Registration form, form add new room and hotel)
>>>>>>> 9201a91 (added new jsp files, new view pages Manage, Home page, Login, Registration form, form add new room and hotel)
}
