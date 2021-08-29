package co.kr.circus.sauceweb.domain.store;

import co.kr.circus.sauceweb.domain.boss.Boss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByBoss(Boss boss);
}
