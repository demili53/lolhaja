package demili53.game.lolhaja.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import demili53.game.lolhaja.Access.domain.AccessResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new AccessResolver());
	}
}
