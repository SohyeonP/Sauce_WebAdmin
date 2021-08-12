package co.kr.circus.sauceweb.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {
    private String name;
    private String phone;
    private String birth;
    private String email;
    private String username;
    private String password;
}
