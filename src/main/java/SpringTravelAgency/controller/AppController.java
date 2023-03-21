package SpringTravelAgency.controller;

import SpringTravelAgency.dao.OrderInterface;
import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.Order;
import SpringTravelAgency.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/showRoom")
    public String getRooms(Model theModel){

        List<Hotel> roomList=order.getRooms();
        theModel.addAttribute("customers", roomList);

        return "form-list";



    }
}
