//package co.kr.circus.sauceweb.shop;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class MemoryShopRepositoryTest {
//
//    @Autowired
//    MemoryShopRepository repository;
//
//    @Test
//    public void save() {
//        Shop shop = new Shop();
//        shop.setBiz_storename("대림피자");
//        shop.setPhone("070-1234-5678");
//        shop.setBiz_bossname("홍길동");
//        shop.setBiz_address("경기도 안양시 동안구");
//        shop.setBiz_number("123-00-45678");
//
//        repository.save(shop);
//
//        Shop result = repository.findById(shop.getStore_id()).get();
//        assertThat(shop).isEqualTo(result);
//    }
//}