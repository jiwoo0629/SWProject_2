package com.jiwoo1.web.dto;

import com.jiwoo1.domain.post.Post;
import lombok.Getter;

@Getter
//Response DTO for the list
public class PostListResponseDTO {
    private Long id;
    private String title;
    private String modified_date;
    private int views;

    public PostListResponseDTO(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.modified_date = entity.Modifieddate();
        this.views = entity.getViews();
    }
}
