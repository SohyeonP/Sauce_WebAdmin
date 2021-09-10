package co.kr.circus.sauceweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SauceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SauceProjectApplication.class, args);
    }

}
