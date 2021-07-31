package co.kr.circus.sauceweb.store.service;

import co.kr.circus.sauceweb.store.dto.Store;
import co.kr.circus.sauceweb.store.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public List<Store> getAll() {
        List<Store> storeList = storeMapper.getAll();
        return storeList;
    }

    @Transactional(rollbackOn=Exception.class)
    public Store add(Store store) throws Exception {
        storeMapper.insert(store);
        if (true) {
            throw new Exception("Legacy Exception");
        }
        return store;
    }
}
