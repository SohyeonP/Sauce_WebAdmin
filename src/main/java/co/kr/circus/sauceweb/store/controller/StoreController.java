package co.kr.circus.sauceweb.store.controller;

import co.kr.circus.sauceweb.store.dto.Store;
import co.kr.circus.sauceweb.store.mapper.StoreMapper;
//import co.kr.circus.sauceweb.shop.service.ShopService;
import co.kr.circus.sauceweb.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores/register")
public class StoreController {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private StoreService storeService;

    @PostMapping("")
    public Store post(@RequestBody Store store) throws Exception {
//        storeMapper.insert(store);
        storeService.add(store);
        return store;
    }

    @GetMapping("")
    public List<Store> getAll() {
        return storeMapper.getAll();
    }

    @GetMapping("/{store_id}")
    public Store getById(@PathVariable("store_id") int store_id) {
        return storeMapper.getById(store_id);
    }
}

