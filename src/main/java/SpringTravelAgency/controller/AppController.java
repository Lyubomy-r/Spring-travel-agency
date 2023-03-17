package SpringTravelAgency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AppController {

    @RequestMapping("/form")
    public String homePage(){
        return "forn";
    }
}
