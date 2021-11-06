package co.kr.circus.sauceweb.web.story.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class StoryImageUpdateRequestDto {
    private MultipartFile attachFile;

    @Builder
    public StoryImageUpdateRequestDto(MultipartFile attachFile) {
        this.attachFile = attachFile;
    }
}
