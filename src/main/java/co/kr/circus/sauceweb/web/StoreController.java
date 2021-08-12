package co.kr.circus.sauceweb.web;

import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.service.StoreService;
import co.kr.circus.sauceweb.web.dto.StoreRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/addStore")
    public String addStore(Model model) {
        model.addAttribute("storeRegisterDto", new StoreRegisterDto());

        return "createShopForm";
    }

    @PostMapping("/addStore")
    public String addStore(StoreRegisterDto storeRegisterDto) {
        storeService.save(storeRegisterDto);

        return "redirect:/addStore";
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
        return "redirect:/storeInfo/"+id;
    }
}
