//package co.kr.circus.sauceweb.shop;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//public class MemoryShopRepository implements ShopRepository{
//
//    private static Map<Long, Shop> shopMap = new HashMap<>();
//    private static long sequence = 0L;
//
//    @Override
//    public Shop save(Shop shop) {
//        shop.setStore_id(++sequence);
//        shopMap.put(shop.getStore_id(), shop);
//        return shop;
//    }
//
//    @Override
//    public Optional<Shop> findById(Long store_id) {
//        return Optional.ofNullable(shopMap.get(store_id));
//    }
//
//    public void clearShopmap() {
//        shopMap.clear();
//    }
//}
