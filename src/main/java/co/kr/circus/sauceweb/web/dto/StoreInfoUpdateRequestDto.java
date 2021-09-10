package co.kr.circus.sauceweb.web.dto;

import lombok.Getter;

@Getter
public class StoreInfoUpdateRequestDto {
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

    public StoreInfoUpdateRequestDto(String storeName, String storePhone, String bossName, String address, String number, String intro, String opening, String breaktime, String holiday, String temholiday) {
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.bossName = bossName;
        this.address = address;
        this.number = number;
        this.intro = intro;
        this.opening = opening;
        this.breaktime = breaktime;
        this.holiday = holiday;
        this.temholiday = temholiday;
    }
}
