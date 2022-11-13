package com.jiwoo1.web.dto;

import com.jiwoo1.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Add Default Construct automatically
@Getter
//Request DTO for saving the post
public class PostSaveRequestDTO {
    private String title;
    private String content;

    @Builder //Use builder instead of constructor
    public PostSaveRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //DTO -> entity
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
