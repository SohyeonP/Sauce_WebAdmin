package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.StoreRepository;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import co.kr.circus.sauceweb.utils.file.FileStore;
import co.kr.circus.sauceweb.web.dto.StoreRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final FileStore fileStore;

    @Transactional
    public Long save(Boss boss, StoreRegisterDto storeRegisterDto) {
        Store store = storeRepository.save(Store.builder()
                .boss(boss)
                .storeName(storeRegisterDto.getStoreName())
                .storePhone(storeRegisterDto.getStorePhone())
                .bossName(storeRegisterDto.getBossName())
                .address(storeRegisterDto.getAddress())
                .number(storeRegisterDto.getNumber())
                .build());
        return store.getId();
    }

    @Transactional
    public void update(Long id, StoreRegisterDto storeRegisterDTO) throws IOException {
        UploadFile attachFile = fileStore.storeFile(storeRegisterDTO.getAttchFile());
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        store.update(storeRegisterDTO, attachFile);
    }

    public StoreRegisterDto findById(Long id) {
        Store entity = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 가게가 존재하지 않습니다.")
        );
        return new StoreRegisterDto(entity);
    }

    public Store findByBoss(Boss boss) {
        return storeRepository.findByBoss(boss).orElseThrow(
                () -> new IllegalArgumentException("등록된 가게가 없습니다."));
    }
}
