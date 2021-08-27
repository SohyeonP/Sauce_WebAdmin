package co.kr.circus.sauceweb.web;

import co.kr.circus.sauceweb.service.BossService;
import co.kr.circus.sauceweb.web.dto.BossSignupDto;
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
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute BossSignupDto bossSignupDto) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute BossSignupDto bossSignupDto) {
        bossService.signup(bossSignupDto);
        return "redirect:/login";
    }
}
