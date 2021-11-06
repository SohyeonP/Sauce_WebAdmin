package co.kr.circus.sauceweb.web.store.dto;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class StoreSaveRequestDto {
    private MultipartFile attachFile;
    private String storeName;
    private String storePhone;
    private String bossName;
    private String address;
    private String number;

    @Builder
    public StoreSaveRequestDto(MultipartFile attachFile, String storeName, String storePhone, String bossName, String address, String number) {
        this.attachFile = attachFile;
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.bossName = bossName;
        this.address = address;
        this.number = number;
    }

    public Store toEntity(UploadFile logo, Boss boss) {
        return Store.builder()
                .boss(boss)
                .logo(logo)
                .storeName(storeName)
                .storePhone(storePhone)
                .bossName(bossName)
                .address(address)
                .number(number)
                .build();
    }
}
