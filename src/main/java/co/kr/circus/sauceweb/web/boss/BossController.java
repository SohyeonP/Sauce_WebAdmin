package co.kr.circus.sauceweb.web.boss;

import co.kr.circus.sauceweb.web.boss.dto.BossSaveRequestDto;
import co.kr.circus.sauceweb.service.BossService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute BossSaveRequestDto bossSaveRequestDto) {
        bossService.save(bossSaveRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public String idCheck(@ModelAttribute BossSaveRequestDto bossSaveRequestDto) {
        String result = bossService.checkUsername(bossSaveRequestDto.getUsername());
        return result;
    }
}
