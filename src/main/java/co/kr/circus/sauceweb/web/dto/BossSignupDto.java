package co.kr.circus.sauceweb.web.dto;

import co.kr.circus.sauceweb.domain.boss.Boss;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BossSignupDto {
    private String name;
    private String phone;
    private String birth;
    private String email;
    private String username;
    private String password;
    private String check1;
    private String check2;

    @Builder
    public BossSignupDto(String name, String phone, String birth, String email, String username, String password, String check1, String check2) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.check1 = check1;
        this.check2 = check2;
    }

    public Boss toEntity(String encodedPassword) {
        return Boss.builder()
                .name(name)
                .phone(phone)
                .birth(birth)
                .email(email)
                .username(username)
                .password(encodedPassword)
                .check1(makeCheck(check1))
                .check2(makeCheck(check2))
                .build();
    }

    public String makeCheck(String check) {
        if (check == null) {
            return "F";
        } else {
            return "T";
        }
    }
}
