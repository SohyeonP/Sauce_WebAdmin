package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.boss.BossRepository;
import co.kr.circus.sauceweb.web.dto.BossSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BossService implements UserDetailsService {
    private final BossRepository bossRepository;

    @Transactional
    public Long signup(BossSaveRequestDto bossSaveRequestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        bossSaveRequestDto.encodePassword(encoder.encode(bossSaveRequestDto.getPassword()));
        return bossRepository.save(bossSaveRequestDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return bossRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
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
