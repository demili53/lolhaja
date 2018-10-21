package demili53.game.lolhaja.front.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import demili53.game.lolhaja.Access.domain.Access;

@Controller
public class FrontController {
	@GetMapping("/")
	public String front(Access access) {
		return "front/front";
	}
}
