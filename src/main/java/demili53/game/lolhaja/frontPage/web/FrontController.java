package demili53.game.lolhaja.frontPage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    @GetMapping("/")
    public String front(){
        return "/front";
    }



}
