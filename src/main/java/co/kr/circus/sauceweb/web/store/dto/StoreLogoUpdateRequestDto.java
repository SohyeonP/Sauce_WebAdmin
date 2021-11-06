package co.kr.circus.sauceweb.web.store.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class StoreLogoUpdateRequestDto {
    private MultipartFile attachFile;

    @Builder
    public StoreLogoUpdateRequestDto(MultipartFile attachFile) {
        this.attachFile = attachFile;
    }
}
