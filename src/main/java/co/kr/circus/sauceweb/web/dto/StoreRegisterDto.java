package co.kr.circus.sauceweb.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
}
