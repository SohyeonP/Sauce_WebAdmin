package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.boss.BossRepository;
import co.kr.circus.sauceweb.web.dto.BossSignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BossService implements UserDetailsService {
    private final BossRepository bossRepository;

    @Transactional
    public Long signup(BossSignupDto bossSignupDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(bossSignupDto.getPassword());
        return bossRepository.save(bossSignupDto.toEntity(encodedPassword)).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Boss> memberWrapper = bossRepository.findByUsername(username);
        Boss boss = memberWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

//        // 여기서는 간단하게 username이 'admin'이면 admin권한 부여
//        if("admin".equals(username)){
//            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
//        }

        // 아이디, 비밀번호, 권한리스트를 매개변수로 User를 만들어 반환해준다.
        return new User(boss.getUsername(), boss.getPassword(), authorities);
    }

    public Boss findByUsername(String username) {
        return bossRepository.findByUsername(username).get();
    }

    public String checkUsername(String username) {
        Optional<Boss> findBoss = bossRepository.findByUsername(username);
        if (findBoss.isPresent()) {
            return "fail";
        }
        return "success";
    }
}
