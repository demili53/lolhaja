package demili53.game.lolhaja.user.domain;

import demili53.game.lolhaja.common.result.CreateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DemiUserRepo userRepo;

    public DemiUser findByLoginId(String loginId){
        return userRepo.findOneByLoginId(loginId);
    }

    public CreateResult createUser(String loginId, String encrytedPassword){
        DemiUser user = userRepo.findOneByLoginId(loginId);
        if(user!=null){
            return new CreateResult(false,null, CreateResult.ResultCase.DUPLICATE);
        }
        DemiUser createdUser = userRepo.save(new DemiUser(loginId,encrytedPassword));

        return new CreateResult(true,createdUser, null);
    }


}
