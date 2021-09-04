package co.kr.circus.sauceweb.web;

import co.kr.circus.sauceweb.service.StoreService;
import co.kr.circus.sauceweb.web.dto.StoreLogoUpdateRequestDto;
import co.kr.circus.sauceweb.web.dto.StoreSaveRequestDto;
import co.kr.circus.sauceweb.web.dto.StoreInfoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/stores/new")
    public String createStoreForm() {
        log.info("GET /stores/new");
        return "createShopForm";
    }

    @PostMapping("/stores/new")
    public String createStore(@AuthenticationPrincipal User user,
                              @ModelAttribute StoreSaveRequestDto storeSaveRequestDto,
                              RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /stores/new");
        if (!storeSaveRequestDto.getAttachFile().isEmpty()) {
            Long storeId = storeService.save(user.getUsername(), storeSaveRequestDto);
            redirectAttributes.addAttribute("id", storeId);
            return "redirect:/stores/{id}";
        } else {
            return "redirect:/stores/new";
        }
    }

    @GetMapping("/stores/{id}")
    public String searchStore(@PathVariable Long id, Model model) {
        log.info("GET /stores/{id}");
        model.addAttribute("storeResponseDto", storeService.findById(id));
        return "storeInfoForm";
    }

    @PostMapping("/stores/{id}")
    public String updateStoreInfo(@PathVariable Long id,
                                  @ModelAttribute StoreInfoUpdateRequestDto storeInfoUpdateRequestDto,
                                  RedirectAttributes redirectAttributes) {
        log.info("POST /stores/{id}");
        storeService.updateInfo(id, storeInfoUpdateRequestDto);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/stores/{id}";
    }

    @PostMapping("/stores/{id}/logo")
    public String updateLogo(@PathVariable Long id,
                             @ModelAttribute StoreLogoUpdateRequestDto storeLogoUpdateRequestDto,
                             RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /stores/{id}/logo");
        if (!storeLogoUpdateRequestDto.getAttachFile().isEmpty()) {
            storeService.updateLogo(id, storeLogoUpdateRequestDto);
            redirectAttributes.addAttribute("id", id);
        }
        return "redirect:/stores/{id}";
    }
}
