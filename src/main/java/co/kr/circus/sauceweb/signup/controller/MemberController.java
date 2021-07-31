package co.kr.circus.sauceweb.signup.controller;

import co.kr.circus.sauceweb.signup.dto.Member;
import co.kr.circus.sauceweb.signup.mapper.MemberMapper;
import co.kr.circus.sauceweb.signup.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // REST 컨트롤러로 동작하도록 지정, Json 형태로 객체 데이터를 반환
@RequestMapping(value = "/sauceweb") // 매핑
@RequiredArgsConstructor //초기화하지 않은 final필드나 @NotNull이 붙은 필드에 대해 생성자를 생성, DI 편의성을 위해 사용
public class MemberController {

    private final MemberService memberService;
    @Autowired
    private MemberMapper memberMapper;
//    @RequestMapping(value="/signup",method={RequestMethod.GET})
//    public String signup() {
//        return "createMemberForm";
//    }

    @RequestMapping(value="/signup",method={RequestMethod.POST})
    public String create(@PathVariable String name, @PathVariable int phone, @PathVariable int birthday, @PathVariable String email, @PathVariable String username, @PathVariable String password) {
        Member member = new Member();
        member.setName(name);
        member.setPhone(phone);
        member.setBirthday(birthday);
        member.setEmail(email);
        member.setUsername(username);
        member.setPassword(password);

        memberService.join(member);

        return "redirect:/";
    }

    @RequestMapping(value="/insert",method={RequestMethod.POST})
    public int DBinsert(@RequestBody Member member) {
        return memberMapper.insert(member);
    }
}
