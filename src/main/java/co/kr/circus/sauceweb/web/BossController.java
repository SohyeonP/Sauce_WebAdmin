package co.kr.circus.sauceweb.web;

import co.kr.circus.sauceweb.service.BossService;
import co.kr.circus.sauceweb.web.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BossController {

    private final BossService bossService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute MemberFormDto memberFormDto) {
//        model.addAttribute("memberFormDto", new MemberFormDto());
        return "createMemberForm";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberFormDto memberFormDto) {
        bossService.signup(memberFormDto);
        return "redirect:/signup";
    }
}
