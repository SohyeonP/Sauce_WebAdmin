package co.kr.circus.sauceweb;

import co.kr.circus.sauceweb.utils.fileupload.properties.StorageProperties;
import co.kr.circus.sauceweb.utils.fileupload.service.FileSystemStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SauceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SauceProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner init(FileSystemStorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
