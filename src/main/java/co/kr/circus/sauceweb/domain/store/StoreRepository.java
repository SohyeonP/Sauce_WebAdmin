package co.kr.circus.sauceweb.domain.store;

import co.kr.circus.sauceweb.web.boss.dto.BossResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByBoss(BossResponseDto dto);
}
