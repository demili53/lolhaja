package demili53.game.lolhaja.join.web;

import demili53.game.lolhaja.user.domain.DemiUser;
import demili53.game.lolhaja.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserJoinContoller {


    @GetMapping("/user/join")
    public String joinUserPage(){

        return "join/joinPage";
    }


}
