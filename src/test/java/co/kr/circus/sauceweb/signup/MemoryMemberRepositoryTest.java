//package co.kr.circus.sauceweb.signup;
//
//import co.kr.circus.sauceweb.signup.dto.Member;
//import co.kr.circus.sauceweb.signup.repository.MemoryMemberRepository;
//import org.junit.Test;
//import org.junit.jupiter.api.AfterEach;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//
//public class MemoryMemberRepositoryTest {
//
//
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    @AfterEach
//    public void afterEach() {
//        repository.clearStore();
//    }
//
//    @Test
//    public void save() {
//        Member member = new Member();
//        member.setUserName("user1");
//        member.setPassword("1234");
//        member.setName("홍길동");
//        member.setPhoneNumber(01012341234);
//        member.setBirth(000101);
//        member.setEmail("test@naver.com");
//
//        repository.save(member);
//
//        Member result =  repository.findById(member.getBoss_id()).get();
//        assertThat(member).isEqualTo(result);
//    }
//
//    @Test
//    public void findByUserName() {
//        Member member1 = new Member();
//        member1.setUserName("user1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setUserName("user2");
//        repository.save(member2);
//
//        Member result = repository.findByUserName("user1").get();
//        assertThat(result).isEqualTo(member1);
//    }
//
//    @Test
//    public void findAll() {
//        Member member1 = new Member();
//        member1.setUserName("user1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setUserName("user2");
//        repository.save(member2);
//
//        List<Member> result = repository.findAll();
//        assertThat(result.size()).isEqualTo(2);
//    }
//
//}
