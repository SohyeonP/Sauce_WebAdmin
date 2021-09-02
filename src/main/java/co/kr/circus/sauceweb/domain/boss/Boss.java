package co.kr.circus.sauceweb.domain.boss;

import co.kr.circus.sauceweb.domain.BaseTimeEntity;
import co.kr.circus.sauceweb.domain.store.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Boss extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "boss")
    private List<Store> stores = new ArrayList<>();

    private String name;
    private String phone;
    private String birth;
    private String email;
    private String username;
    private String password;
    private String personalInfoTermYn;
    private String sauceServiceTermYn;

    @Builder
    public Boss(List<Store> stores, String name, String phone, String birth, String email, String username, String password, String personalInfoTermYn, String sauceServiceTermYn) {
        this.stores = stores;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.personalInfoTermYn = personalInfoTermYn;
        this.sauceServiceTermYn = sauceServiceTermYn;
    }
}
