package co.kr.circus.sauceweb.web.dto;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class StoreRegisterDto {
    private Long id;
    private MultipartFile attachFile;
    private UploadFile logo;
    private String storeName;
    private String storePhone;
    private String bossName;
    private String address;
    private String number;
    private String intro;
    private String opening;
    private String breaktime;
    private String holiday;
    private String temholiday;
    private Boss boss;

    public StoreRegisterDto(Store entity) {
        this.id = entity.getId();
        this.logo = entity.getLogo();
        this.storeName = entity.getStoreName();
        this.storePhone = entity.getStorePhone();
        this.bossName = entity.getBossName();
        this.address = entity.getAddress();
        this.number = entity.getNumber();
        this.intro = entity.getIntro();
        this.opening = entity.getOpening();
        this.breaktime = entity.getBreaktime();
        this.holiday = entity.getHoliday();
        this.temholiday = entity.getTemholiday();
        this.boss = entity.getBoss();
    }

    public void addLogo(UploadFile logo) {
        this.logo = logo;
    }

    public void addBoss(Boss boss) {
        this.boss = boss;
    }

    public Store toEntity() {
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
