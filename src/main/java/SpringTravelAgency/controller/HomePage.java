package SpringTravelAgency.controller;


import SpringTravelAgency.entity.Hotel;
import SpringTravelAgency.entity.User;
import SpringTravelAgency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePage {

    private HotelService hotelService;
    @Autowired
    public HomePage(HotelService hotelService){
        this.hotelService=hotelService;

    }

    @GetMapping("/")
    public String homePage(Model theModel){
        List<Hotel> countryList= hotelService.getHotelList();
        theModel.addAttribute("countryList",countryList);
        return "index";
    }



    @GetMapping("/homepage")
    public String homepage(){

        return "home-page";
    }




}
