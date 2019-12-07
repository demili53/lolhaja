package demili53.game.lolhaja.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemiUserRepo extends JpaRepository<DemiUser,Long> {

    DemiUser findOneByLoginId(String loginId);
}
