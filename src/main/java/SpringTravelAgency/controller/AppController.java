package SpringTravelAgency.controller;

import SpringTravelAgency.dao.OrderInterface;
import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AppController {

    private OrderInterface order;
   @Autowired
   public AppController ( OrderInterface order){
       this.order=order;
   }

    @RequestMapping("/form")
    public String homePage(){
        return "forn";
    }

    @GetMapping("/showHotel")
    public String getHotel(Model theModel){

        List<Hotel> roomList=order.getRooms();
        theModel.addAttribute("customers", roomList);
        List<Room> roomList1 = roomList.get(0).getRooms();
        theModel.addAttribute("roomList", roomList1);

        return "form-list";
    }
    @RequestMapping("/freeHotel")
    public String freeHotel(Model theModel){
        LocalDate myDate=LocalDate.of(2023,03,23);
        List<Room> rooms=order.freeRoomList(myDate);
       List <Hotel> hotels= rooms.stream().map(a->a.getHotel()).toList();
        theModel.addAttribute("customers", rooms);
        return "form-list";
    }

    @RequestMapping("/addHotel")
    public String addHotel(Model theModel){
        Hotel hotel=new Hotel();

        hotel.setNameHotel("MAlima LI");
        hotel.setDescription("Best hotel in Maiymi");
        hotel.setCountry("Maiymi");
        hotel.setCity("Island Fery");
        order.addHotel(hotel);

        theModel.addAttribute("customers", hotel);
        return "form-list";
    }

    @RequestMapping ("/addRoom")
    public String addRoom(Model theModel){
        Hotel hotel=order.getHotel(1L);
        Room room=new Room();

        room.setNumberRoom(10);
        room.setType("SINGEl");
        room.setPrice(3500.00);
        room.addHotelToRoom(hotel);
        order.addRoom(room);

        theModel.addAttribute("customers", room);

        return"redirect:/api/showRoom";
    }
    @RequestMapping("/showRoom")
    public String showRoom(Model theModel){
        List<Room> roomList=order.RoomList();

        theModel.addAttribute("customers", roomList);

        return "list-room";
    }
}
