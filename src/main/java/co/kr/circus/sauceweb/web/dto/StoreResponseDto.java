package co.kr.circus.sauceweb.web.dto;

import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import lombok.Getter;

@Getter
public class StoreResponseDto {

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

    public StoreResponseDto(Store entity) {
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
    }
}
