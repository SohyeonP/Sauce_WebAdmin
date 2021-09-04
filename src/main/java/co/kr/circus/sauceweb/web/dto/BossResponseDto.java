package co.kr.circus.sauceweb.web.dto;

import co.kr.circus.sauceweb.domain.boss.Boss;
import co.kr.circus.sauceweb.domain.store.Store;
import lombok.Getter;

import java.util.List;

@Getter
public class BossResponseDto {
    private Long id;
    private List<Store> stores;
    private String name;
    private String phone;
    private String birth;
    private String email;
    private String username;
    private String password;
    private String personalInfoTermYn;
    private String sauceServiceTermYn;

    public BossResponseDto(Boss entity) {
        this.id = entity.getId();
        this.stores = entity.getStores();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.birth = entity.getBirth();
        this.email = entity.getEmail();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.personalInfoTermYn = entity.getPersonalInfoTermYn();
        this.sauceServiceTermYn = entity.getSauceServiceTermYn();
    }

}
