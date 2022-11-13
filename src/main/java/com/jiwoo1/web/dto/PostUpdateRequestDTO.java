package com.jiwoo1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Add Default Construct automatically
@Getter
//Request DTO for updating the post
public class PostUpdateRequestDTO {
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
