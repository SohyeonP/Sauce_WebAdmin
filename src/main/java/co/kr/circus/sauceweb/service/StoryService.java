package co.kr.circus.sauceweb.service;

import co.kr.circus.sauceweb.web.story.dto.StoryResponseDto;
import co.kr.circus.sauceweb.web.story.dto.StorySaveRequestDto;
import co.kr.circus.sauceweb.web.story.dto.StoryImageUpdateRequestDto;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.StoreRepository;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import co.kr.circus.sauceweb.domain.story.Story;
import co.kr.circus.sauceweb.domain.story.StoryRepository;
import co.kr.circus.sauceweb.utils.file.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;
    private final StoreRepository storeRepository;
    private final FileStore fileStore;

    @Transactional
    public Long save(Long id, StorySaveRequestDto storySaveRequestDto) throws IOException {
        UploadFile image = fileStore.storeFile(storySaveRequestDto.getAttachFile());
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다. " + id)
        );
        return storyRepository.save(storySaveRequestDto.toEntity(image, store)).getId();
    }

    public StoryResponseDto findById(Long id) {
        Story entity = storyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 가게가 존재하지 않습니다.")
        );
        return new StoryResponseDto(entity);
    }

    @Transactional
    public void updateImage(Long id, StoryImageUpdateRequestDto storyImageUpdateRequestDto) throws IOException {
        Story story = storyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        String storyFileName = story.getImage().getStoreFileName();
        if (storyFileName != null) {
            fileStore.deleteFile(storyFileName);
        }
        UploadFile image = fileStore.storeFile(storyImageUpdateRequestDto.getAttachFile());
        story.updateImage(image);
    }

}
