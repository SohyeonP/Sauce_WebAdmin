package co.kr.circus.sauceweb.domain.story;

import co.kr.circus.sauceweb.domain.store.Store;
import co.kr.circus.sauceweb.domain.store.UploadFile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class Story {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UploadFile image;
    private String title;
    private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Story(UploadFile image, String title, String content, Store store) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.store = store;
    }

    public void updateImage(UploadFile image) {
        this.image = image;
    }

    //==연관관계 편의 메서드==//
    public void setStore(Store store) {
        this.store = store;
        store.getStories().add(this);
    }
}
