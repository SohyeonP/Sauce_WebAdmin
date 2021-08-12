package co.kr.circus.sauceweb.domain.boss;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BossRepository extends JpaRepository<Boss, Long> {
    Boss findByUsername(String bossId);
}