package com.jiwoo1.web.dto;

import com.jiwoo1.domain.post.Post;
import lombok.Getter;

@Getter
//Response DTO for the post
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String created_date; //Get response as String format
    private String modified_date; //Get response as String foramt
    private int views;

    //entity -> DTO
    public PostResponseDTO(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.created_date = entity.Createddate();
        this.modified_date = entity.Modifieddate();
        this.views = entity.getViews();
    }
}
