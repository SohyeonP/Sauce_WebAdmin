package co.kr.circus.sauceweb.web.story.dto;


import co.kr.circus.sauceweb.domain.store.UploadFile;
import co.kr.circus.sauceweb.domain.story.Story;
import lombok.Getter;

@Getter
public class StoryResponseDto {

    private Long id;
    private UploadFile image;
    private String title;
    private String content;

    public StoryResponseDto(Story entity) {
        this.id = entity.getId();
        this.image = entity.getImage();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

}
