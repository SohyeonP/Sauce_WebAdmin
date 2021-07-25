package co.kr.circus.sauceweb.signup.repository;

import co.kr.circus.sauceweb.signup.dto.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setBoss_id(sequence++);
        store.put(member.getBoss_id(), member);
        Date date = new Date();
        member.setCreatedAt(date);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        return store.values().stream()
                .filter(member -> member.getUserName().equals(userName))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
