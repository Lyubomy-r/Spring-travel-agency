package SpringTravelAgency.controller;

import SpringTravelAgency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Set;

@Controller
public class HomePage {

    private final HotelService hotelService;

    @Autowired
    public HomePage(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String homePage(Model theModel) {
        Set<String> countryList = hotelService.getCountryList();
        theModel.addAttribute("countryList", countryList);
        return "index";
    }
}
