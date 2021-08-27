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

    public StoreRegisterDto(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.storePhone = store.getStorePhone();
        this.bossName = store.getBossName();
        this.address = store.getAddress();
        this.number = store.getNumber();
        this.intro = store.getIntro();
        this.opening = store.getOpening();
        this.breaktime = store.getBreaktime();
        this.holiday = store.getHoliday();
        this.temholiday = store.getTemholiday();
    }
}
