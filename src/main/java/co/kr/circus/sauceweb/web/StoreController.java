package co.kr.circus.sauceweb.web;

import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.service.BossService;
import co.kr.circus.sauceweb.service.StoreService;
import co.kr.circus.sauceweb.web.dto.BossResponseDto;
import co.kr.circus.sauceweb.web.dto.StoreRegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StoreController {

    private final StoreService storeService;
    private final BossService bossService;

    @GetMapping("/stores/new")
    public String addStoreForm() {
        log.info("GET /stores/new");
        return "createShopForm";
    }

    @PostMapping("/stores/new")
    public String addStore(@AuthenticationPrincipal User user,
                           @ModelAttribute StoreRegisterDto storeSaveRequestDto,
                           RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /stores/new");
        Long storeId = storeService.save(user.getUsername(), storeSaveRequestDto);
        redirectAttributes.addAttribute("id", storeId);
        return "redirect:/stores/{id}";
    }

    @GetMapping("/stores/{id}")
    public String readStore(@AuthenticationPrincipal User user, @PathVariable Long id, Model model) {
        log.info("GET /stores/{id}");
        model.addAttribute("storeRegisterDto", storeService.findById(id));
        return "storeInfoForm";
    }

    @PostMapping("/stores/{id}")
    public String updateStore(@AuthenticationPrincipal User user,
                              @ModelAttribute StoreRegisterDto storeRegisterDto,
                              @PathVariable Long id,
                              RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /stores/{id}");
        storeService.update(user.getUsername(), storeRegisterDto);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/stores/{id}";
    }
}
