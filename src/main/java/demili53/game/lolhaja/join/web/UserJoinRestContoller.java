package demili53.game.lolhaja.join.web;

import demili53.game.lolhaja.common.result.CreateResult;
import demili53.game.lolhaja.user.domain.DemiUser;
import demili53.game.lolhaja.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserJoinRestContoller {

    @Autowired
    private UserService userService;

    @PostMapping("/user/join")
    public Map<String,Object> joinUser(@RequestParam String loginId,@RequestParam String password){
        Map<String,Object> result = new HashMap<>();

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        CreateResult createResult = userService.createUser(loginId,passwordEncoder.encode(password));
        result.put("result",createResult);
        return result;
    }

}
