//package co.kr.circus.sauceweb.shop;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class ShopServiceTest {
//
//    @Autowired ShopService shopService;
//    @Autowired MemoryShopRepository shopRepository;
//
//    @Test
//    void write() {
//        Shop shop = new Shop();
//        shop.setBiz_storename("대림피자");
//        shop.setPhone("070-1234-5678");
//        shop.setBiz_bossname("홍길동");
//        shop.setBiz_address("경기도 안양시 동안구");
//        shop.setBiz_number("123-00-45678");
//
//        Long saveId = shopService.write(shop);
//    }
//}