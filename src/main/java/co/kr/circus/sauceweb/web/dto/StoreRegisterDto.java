package co.kr.circus.sauceweb.web.dto;

import co.kr.circus.sauceweb.domain.store.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreRegisterDto {
    private Long id;
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

    public StoreRegisterDto(Store entity) {
        this.id = entity.getId();
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
