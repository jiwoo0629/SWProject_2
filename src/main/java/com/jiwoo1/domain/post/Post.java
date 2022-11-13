package com.jiwoo1.domain.post;

import com.jiwoo1.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity //Entity for Post
public class Post extends BaseTimeEntity {
    @Id //key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long id; //key value of post
    @Column(length = 500, nullable = false)
    private String title; //title of the post
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; //content of the post
    private int views; //views of the post
    @Builder //Use Builder class instead of Constructor
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.views = 0;
    }

    //function for updating the post
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //Getter
    public Long getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getContent() { return this.content; }
    public int getViews() { return this.views; }
    //Setter
    public void setViews(int views) { this.views = views; }


}
