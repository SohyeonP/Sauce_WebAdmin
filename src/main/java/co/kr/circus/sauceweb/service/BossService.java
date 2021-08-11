package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.boss.BossRepository;
import co.kr.circus.sauceweb.web.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BossService {
    private final BossRepository bossRepository;

    public void signup(MemberFormDto memberFormDto) {
        bossRepository.save(Boss.builder()
                .name(memberFormDto.getName())
                .phone(memberFormDto.getPhone())
                .birth(memberFormDto.getBirth())
                .email(memberFormDto.getEmail())
                .username(memberFormDto.getUsername())
                .password(memberFormDto.getPassword()).build());
    }
}
