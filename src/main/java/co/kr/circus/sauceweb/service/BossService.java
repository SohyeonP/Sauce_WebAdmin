package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.boss.BossRepository;
import co.kr.circus.sauceweb.web.boss.dto.BossResponseDto;
import co.kr.circus.sauceweb.web.boss.dto.BossSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BossService implements UserDetailsService {
    private final BossRepository bossRepository;

    @Transactional
    public Long save(BossSaveRequestDto bossSaveRequestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        bossSaveRequestDto.encodePassword(encoder.encode(bossSaveRequestDto.getPassword()));
        return bossRepository.save(bossSaveRequestDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Boss entity = bossRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(entity.getUsername(), entity.getPassword(), new ArrayList<>());
    }

    public BossResponseDto findByUsername(String username) {
        Boss boss = bossRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new BossResponseDto(boss);
    }

    public String checkUsername(String username) {
        Optional<Boss> findBoss = bossRepository.findByUsername(username);
        if (findBoss.isPresent()) {
            return "fail";
        }
        return "success";
    }
}
