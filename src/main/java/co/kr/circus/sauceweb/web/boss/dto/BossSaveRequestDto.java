package co.kr.circus.sauceweb.web.boss.dto;

import co.kr.circus.sauceweb.domain.boss.Boss;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BossSaveRequestDto {
    private String name;
    private String phone;
    private String birth;
    private String email;
    private String username;
    private String password;
    private String personalInfoTermYn;
    private String sauceServiceTermYn;

    @Builder
    public BossSaveRequestDto(String name, String phone, String birth, String email, String username, String password, String personalInfoTermYn, String sauceServiceTermYn) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.personalInfoTermYn = personalInfoTermYn;
        this.sauceServiceTermYn = sauceServiceTermYn;
    }

    public Boss toEntity() {
        return Boss.builder()
                .name(name)
                .phone(phone)
                .birth(birth)
                .email(email)
                .username(username)
                .password(password)
                .personalInfoTermYn(makeCheck(personalInfoTermYn))
                .sauceServiceTermYn(makeCheck(sauceServiceTermYn))
                .build();
    }

    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }



    public String makeCheck(String check) {
        if (check == null) {
            return "N";
        } else {
            return "Y";
        }
    }
}
