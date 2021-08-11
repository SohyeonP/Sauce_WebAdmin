package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.StoreRepository;
import co.kr.circus.sauceweb.web.dto.StoreRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void save(StoreRegisterDto storeRegisterDto) {
        storeRepository.save(Store.builder()
                .storeName(storeRegisterDto.getStoreName())
                .storePhone(storeRegisterDto.getStorePhone())
                .bossName(storeRegisterDto.getBossName())
                .address(storeRegisterDto.getAddress())
                .number(storeRegisterDto.getNumber())
                .build());
    }

    @Transactional
    public void update(Long id, StoreRegisterDto storeRegisterDTO) {
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        store.update(storeRegisterDTO);
    }

    public Store findById(Long id) {
        return storeRepository.findById(id).get();
    }
}
