package com.jiwoo1.web;

import com.jiwoo1.web.dto.*;
import com.jiwoo1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //
@RestController
//Controller that links to PostService
public class PostController {
    private final PostService postService;

    @PostMapping("/board/write") //if post request
    public Long write(@RequestBody PostSaveRequestDTO request) {
        //Do not save request if title or content is null
        if(request.getTitle() == "" || request.getContent() == "")
            return Long.valueOf(-1);
        else
            return postService.write(request); //get request as DTO and send to postService:save method
    }

    @PutMapping("/board/modify/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDTO request) {
        //Do not update request if title or content is null
        if(request.getTitle() == "" || request.getContent() == "")
            return Long.valueOf(-1);
        else
            return postService.update(id, request);
    }

    @DeleteMapping("/api/v1/post/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDTO findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/api/v1/post/list")
    public Page<PostListResponseDTO> findAll(Pageable pageable) {
        return postService.findAllDesc(pageable);
    }
}
