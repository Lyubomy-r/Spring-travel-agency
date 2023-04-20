package SpringTravelAgency.controller;


import SpringTravelAgency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomePage {

    private HotelService hotelService;
    @Autowired
    public HomePage(HotelService hotelService){
        this.hotelService=hotelService;

    }

    @GetMapping("/")
    public String homePage(Model theModel){
        Set<String> countryList= hotelService.getHotelList().stream().map(hotel -> hotel.getCountry()).collect(Collectors.toSet());
        theModel.addAttribute("countryList",countryList);
        return "index";
    }

}
