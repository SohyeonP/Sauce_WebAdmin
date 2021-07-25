package co.kr.circus.sauceweb.signup.controller;

import co.kr.circus.sauceweb.signup.MemberForm;
import co.kr.circus.sauceweb.signup.dto.Member;
import co.kr.circus.sauceweb.signup.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup/createMemberForm";
    }

    @PostMapping("/signup")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setPhoneNumber(form.getPhoneNumber());
        member.setBirth(form.getBirth());
        member.setEmail(form.getEmail());
        member.setUserName(form.getUserName());
        member.setPassword(form.getPassword());

        memberService.join(member);

        return "redirect:/";
    }
}
