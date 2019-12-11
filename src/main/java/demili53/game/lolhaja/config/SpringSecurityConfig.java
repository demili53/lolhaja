package demili53.game.lolhaja.config;

import demili53.game.lolhaja.login.domain.DemiLoginFailureHandler;
import demili53.game.lolhaja.login.domain.DemiLoginProvider;
import demili53.game.lolhaja.login.domain.DemiLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DemiLoginProvider demiLoginProvider;
    @Autowired
    private DemiLoginSuccessHandler demiLoginSuccessHandler;
    @Autowired
    private DemiLoginFailureHandler demiLoginFailureHandler;





    @Override
    public void configure(WebSecurity web) throws Exception {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        // 로그인 설정
        http.authorizeRequests()
                // ROLE_USER, ROLE_ADMIN으로 권한 분리 유알엘 정의
                .antMatchers("/", "/user/login", "/error**","/user/join/**").permitAll()
                .antMatchers("/**").access("ROLE_USER")
                .antMatchers("/**").access("ROLE_ADMIN")
                .antMatchers("/admin/**").access("ROLE_ADMIN")
                .antMatchers("/**").authenticated()
                .and()
                // 로그인 페이지 및 성공 url, handler 그리고 로그인 시 사용되는 id, password 파라미터 정의
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .failureHandler(demiLoginFailureHandler)
                .successHandler(demiLoginSuccessHandler)
                .usernameParameter("id")
                .passwordParameter("password")
                .and()
                // 로그아웃 관련 설정
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                // csrf 사용유무 설정
                // csrf 설정을 사용하면 모든 request에 csrf 값을 함께 전달해야한다.
                .csrf().disable()
                // 로그인 프로세스가 진행될 provider
                .authenticationProvider(demiLoginProvider);
    }



}
