package co.kr.circus.sauceweb.domain.boss;

import co.kr.circus.sauceweb.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Boss extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String birth;
    private String email;
    private String username;
    private String password;

    @Builder
    public Boss(String name, String phone, String birth, String email, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
