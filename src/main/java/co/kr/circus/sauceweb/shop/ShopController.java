//package co.kr.circus.sauceweb.shop;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class ShopController {
//
//    private final ShopService shopService;
//
//    @Autowired
//    public ShopController(ShopService shopService) {
//        this.shopService = shopService;
//    }
//
//    @GetMapping("/store-register")
//    public String createForm() {
//        return "createShopForm";
//    }
//
//    @PostMapping("/store-register")
//    public String create(ShopForm form) {
//        Shop shop = new Shop();
//        shop.setBiz_storename(form.getBiz_storename());
//        shop.setPhone(form.getPhone());
//        shop.setBiz_bossname(form.getBiz_bossname());
//        shop.setBiz_address(form.getBiz_address());
//        shop.setBiz_number(form.getBiz_number());
//
//        shopService.write(shop);
//
//        return "redirect:/";
//    }
//}
