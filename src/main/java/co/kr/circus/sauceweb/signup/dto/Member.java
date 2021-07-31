package co.kr.circus.sauceweb.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

//필드에 대한 기본 getter, setter 생성, AccessLevel 미명시 시 접근 제한자는 public
@Getter
@Setter
@AllArgsConstructor // 모든 필드에 대한 생성자 자동 생성
@NoArgsConstructor // 파라미터 없는 생성자 생성
public class Member {
    private Long boss_id;
    private String name;
    private int phone;
    private int birthday;
    private String email;
    private String username;
    private String password;
    private Date createdAt;
    private Date updateAt;
}
