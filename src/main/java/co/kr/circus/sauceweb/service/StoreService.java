package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.boss.BossRepository;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.StoreRepository;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import co.kr.circus.sauceweb.utils.file.FileStore;
import co.kr.circus.sauceweb.web.dto.BossResponseDto;
import co.kr.circus.sauceweb.web.dto.StoreRegisterDto;
import co.kr.circus.sauceweb.web.dto.StoreSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final BossRepository bossRepository;
    private final FileStore fileStore;

    @Transactional
    public Long save(String username, StoreSaveRequestDto storeSaveRequestDto) throws IOException {
        UploadFile logo = fileStore.storeFile(storeSaveRequestDto.getAttachFile());
        Boss boss = bossRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다. " + username));
        return storeRepository.save(storeSaveRequestDto.toEntity(logo, boss)).getId();
    }

    @Transactional
    public void update(String username, StoreRegisterDto storeRegisterDto) throws IOException {
        UploadFile logo = fileStore.storeFile(storeRegisterDto.getAttachFile());
        Boss boss = bossRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다. " + username));
        storeRegisterDto.addLogo(logo);
        storeRegisterDto.addBoss(boss);
        Store store = storeRepository.findById(storeRegisterDto.getId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        store.update(storeRegisterDto);
    }

    public StoreRegisterDto findById(Long id) {
        Store entity = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 가게가 존재하지 않습니다.")
        );
        return new StoreRegisterDto(entity);
    }

    @Transactional(readOnly = true)
    public StoreRegisterDto findByBoss(BossResponseDto dto) {
        return storeRepository.findByBoss(dto).stream()
                .map(StoreRegisterDto::new)
                .collect(Collectors.toList()).get(0);
    }
}
