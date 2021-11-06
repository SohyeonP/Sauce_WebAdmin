package co.kr.circus.sauceweb.web.story;

import co.kr.circus.sauceweb.web.story.dto.StorySaveRequestDto;
import co.kr.circus.sauceweb.web.story.dto.StoryImageUpdateRequestDto;
import co.kr.circus.sauceweb.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class StoryController {

    private final StoryService storyService;

    @GetMapping("/stores/{id}/stories/insert")
    public String insertStoryForm() {
        return "insertStoryForm";
    }

    @PostMapping("/stores/{id}/stories/insert")
    public String insertStory(@PathVariable Long id,
                              @ModelAttribute StorySaveRequestDto storySaveRequestDto,
                              RedirectAttributes redirectAttributes) throws IOException {
        if (!storySaveRequestDto.getAttachFile().isEmpty()) {
            storyService.save(id, storySaveRequestDto);
            redirectAttributes.addAttribute("id", id);
            return "redirect:/stores/{id}";
        } else {
            return "redirect:/stores/new";
        }
    }

    @PostMapping("/stories/{id}/image")
    public String updateImage(@PathVariable Long id,
                              @ModelAttribute StoryImageUpdateRequestDto storyImageUpdateRequestDto,
                              RedirectAttributes redirectAttributes) throws IOException {
        if (!storyImageUpdateRequestDto.getAttachFile().isEmpty()) {
            storyService.updateImage(id, storyImageUpdateRequestDto);
            redirectAttributes.addAttribute("id", id);
        }
        return "redirect:/stores/{id}";
    }
}
