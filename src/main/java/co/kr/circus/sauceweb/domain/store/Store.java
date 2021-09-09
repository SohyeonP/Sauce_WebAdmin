package co.kr.circus.sauceweb.domain.store;

import co.kr.circus.sauceweb.domain.BaseTimeEntity;
import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.story.Story;
import co.kr.circus.sauceweb.web.store.dto.StoreInfoUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "boss_id")
    private Boss boss;

    @OneToMany(mappedBy = "store")
    private List<Story> stories = new ArrayList<>();

    @Embedded
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

    @Builder
    public Store(Boss boss, UploadFile logo, String storeName, String storePhone, String bossName, String address, String number, String intro, String opening, String breaktime, String holiday, String temholiday) {
        this.setBoss(boss);
        this.logo = logo;
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

    public void updateInfo(StoreInfoUpdateRequestDto storeInfoUpdateRequestDto) {
        this.storeName = storeInfoUpdateRequestDto.getStoreName();
        this.storePhone = storeInfoUpdateRequestDto.getStorePhone();
        this.bossName = storeInfoUpdateRequestDto.getBossName();
        this.address = storeInfoUpdateRequestDto.getAddress();
        this.number = storeInfoUpdateRequestDto.getNumber();
        this.intro = storeInfoUpdateRequestDto.getIntro();
        this.opening = storeInfoUpdateRequestDto.getOpening();
        this.breaktime = storeInfoUpdateRequestDto.getBreaktime();
        this.holiday = storeInfoUpdateRequestDto.getHoliday();
        this.temholiday = storeInfoUpdateRequestDto.getTemholiday();
    }

    public void updateLogo(UploadFile logo) {
        this.logo = logo;
    }

    //==연관관계 편의 메서드==//
    public void setBoss(Boss boss) {
        this.boss = boss;
        boss.getStores().add(this);
    }
}
