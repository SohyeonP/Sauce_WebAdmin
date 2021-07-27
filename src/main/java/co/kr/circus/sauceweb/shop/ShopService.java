//package co.kr.circus.sauceweb.shop;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShopService {
//
//    private final ShopRepository shopRepository;
//
//    @Autowired
//    public ShopService(ShopRepository shopRepository) {
//        this.shopRepository = shopRepository;
//    }
//    /**
//     * 업체 등록
//     */
//    public Long write(Shop shop) {
//        shopRepository.save(shop);
//        return shop.getStore_id();
//    }
//}
