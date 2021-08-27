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

    @Builder
    public BossSignupDto(String name, String phone, String birth, String email, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Boss toEntity(String encodedPassword) {
        return Boss.builder()
                .name(name)
                .phone(phone)
                .birth(birth)
                .email(email)
                .username(username)
                .password(encodedPassword)
                .build();
    }

}
