package co.kr.circus.sauceweb.web;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.service.BossService;
import co.kr.circus.sauceweb.service.StoreService;
import co.kr.circus.sauceweb.web.dto.StoreRegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StoreController {

    private final StoreService storeService;
    private final BossService bossService;

    @GetMapping("/addStore")
    public String addStore(@AuthenticationPrincipal User user, Model model) {
        Boss findBoss = bossService.findByUsername(user.getUsername());

        try {
            Long storeId = storeService.findByBoss(findBoss).getId();
            return "redirect:/storeInfo/" + storeId;
        } catch (Exception e) {
            model.addAttribute("storeRegisterDto", new StoreRegisterDto());
            return "createShopForm";
        }
    }

    @PostMapping("/addStore")
    public String addStore(@AuthenticationPrincipal User user, @ModelAttribute StoreRegisterDto storeRegisterDto) {
        Boss findBoss = bossService.findByUsername(user.getUsername());
        Long storeId = storeService.save(findBoss, storeRegisterDto);

        return "redirect:/storeInfo/" + storeId;
    }

    @GetMapping("/storeInfo/{id}")
    public String updateStore(@PathVariable Long id, Model model) {
        Store store = storeService.findById(id);
        StoreRegisterDto storeRegisterDto = new StoreRegisterDto();
        storeRegisterDto.setStoreName(store.getStoreName());
        storeRegisterDto.setStorePhone(store.getStorePhone());
        storeRegisterDto.setBossName(store.getBossName());
        storeRegisterDto.setAddress(store.getAddress());
        storeRegisterDto.setNumber(store.getNumber());
        storeRegisterDto.setIntro(store.getIntro());
        storeRegisterDto.setOpening(store.getOpening());
        storeRegisterDto.setBreaktime(store.getBreaktime());
        storeRegisterDto.setHoliday(store.getHoliday());
        storeRegisterDto.setTemholiday(store.getTemholiday());

        model.addAttribute("storeRegisterDto", storeRegisterDto);

        return "storeInfoForm";
    }

    @PostMapping("/storeInfo/{id}")
    public String updateStore(@PathVariable Long id, @ModelAttribute StoreRegisterDto storeRegisterDto) {
        storeService.update(id, storeRegisterDto);

        return "redirect:/storeInfo/" + id;
    }
}
