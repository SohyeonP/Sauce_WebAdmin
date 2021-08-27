package co.kr.circus.sauceweb.domain.boss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BossRepository extends JpaRepository<Boss, Long> {
//    @Query("SELECT b FROM Boss b WHERE b.username= :username")
    Optional<Boss> findByUsername(String username);
}