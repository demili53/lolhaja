package demili53.game.lolhaja.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DemiUserRepo userRepo;
    public DemiUser findByLoginId(String loginId){
        return userRepo.findOneByLoginId(loginId);
    }
}
