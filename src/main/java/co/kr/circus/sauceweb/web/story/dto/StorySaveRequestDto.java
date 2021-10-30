package co.kr.circus.sauceweb.web.story.dto;

import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import co.kr.circus.sauceweb.domain.story.Story;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class StorySaveRequestDto {
    private MultipartFile attachFile;
    private String title;
    private String content;

    @Builder
    public StorySaveRequestDto(MultipartFile attachFile, String title, String content) {
        this.attachFile = attachFile;
        this.title = title;
        this.content = content;
    }

    public Story toEntity(UploadFile image, Store store) {
        return Story.builder()
                .store(store)
                .image(image)
                .title(title)
                .content(content)
                .build();
    }
}
