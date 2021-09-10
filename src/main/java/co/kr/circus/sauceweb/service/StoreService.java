package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.boss.BossRepository;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.StoreRepository;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import co.kr.circus.sauceweb.utils.file.FileStore;
import co.kr.circus.sauceweb.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final BossRepository bossRepository;
    private final FileStore fileStore;

    @Transactional
    public Long save(String username, StoreSaveRequestDto storeSaveRequestDto) throws IOException {
        UploadFile logo = fileStore.storeFile(storeSaveRequestDto.getAttachFile());
        Boss boss = bossRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다. " + username)
        );
        return storeRepository.save(storeSaveRequestDto.toEntity(logo, boss)).getId();
    }

    @Transactional
    public void updateInfo(Long id, StoreInfoUpdateRequestDto storeInfoUpdateRequestDto) {
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        store.updateInfo(storeInfoUpdateRequestDto);
    }

    public StoreResponseDto findById(Long id) {
        Store entity = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 가게가 존재하지 않습니다.")
        );
        return new StoreResponseDto(entity);
    }

    @Transactional
    public void updateLogo(Long id, StoreLogoUpdateRequestDto storeLogoUpdateRequestDto) throws IOException {
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        String storeFileName = store.getLogo().getStoreFileName();
        if (storeFileName != null) {
            fileStore.deleteFile(storeFileName);
        }
        UploadFile logo = fileStore.storeFile(storeLogoUpdateRequestDto.getAttachFile());
        store.updateLogo(logo);
    }
}
