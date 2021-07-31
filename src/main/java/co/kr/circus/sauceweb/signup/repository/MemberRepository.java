package co.kr.circus.sauceweb.signup.repository;

import co.kr.circus.sauceweb.signup.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByUserName(String userName);
    List<Member> findAll();
}
