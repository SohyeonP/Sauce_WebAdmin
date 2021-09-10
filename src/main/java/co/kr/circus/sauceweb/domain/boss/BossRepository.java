package co.kr.circus.sauceweb.domain.boss;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BossRepository extends JpaRepository<Boss, Long> {
    Optional<Boss> findByUsername(String username);
}