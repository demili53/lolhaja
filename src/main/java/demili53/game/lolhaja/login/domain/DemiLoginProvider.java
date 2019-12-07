package demili53.game.lolhaja.login.domain;

import demili53.game.lolhaja.user.domain.DemiAuth;
import demili53.game.lolhaja.user.domain.DemiUser;
import demili53.game.lolhaja.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 로그인 메칭
 */
@Component
public class DemiLoginProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String id = authentication.getName();

        DemiUser user = userService.findByLoginId(id);
        //test용
        System.out.println(passwordEncoder.encode(authentication.getCredentials().toString()));


        // email에 맞는 user가 없거나 비밀번호가 맞지 않는 경우.
        if (null == user || passwordEncoder.matches(authentication.getCredentials().toString(),user.getPassword())) {
            return null;
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        // 로그인한 계정에게 권한 부여
        if (user.isAdmin()) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(DemiAuth.ROLE_ADMIN.getAuthString()));
        } else {
            grantedAuthorityList.add(new SimpleGrantedAuthority(DemiAuth.ROLE_MEMBER.getAuthString()));
        }

        // 로그인 성공시 로그인 사용자 정보 반환
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(id,user.getPassword(),grantedAuthorityList);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }



}
