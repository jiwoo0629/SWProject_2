package com.jiwoo1.service;

import com.jiwoo1.web.dto.*;
import com.jiwoo1.domain.post.Post;
import com.jiwoo1.domain.post.PostNotFoundException;
import com.jiwoo1.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@EnableTransactionManagement
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional//if error -> rollback
    public Long write(PostSaveRequestDTO request) {
        //save request into postRepository
        return postRepository.save(request.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDTO request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        //Update title or content of the post
        post.update(request.getTitle(), request.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        postRepository.delete(post); //delete the post
    }

    @Transactional
    public PostResponseDTO findById(Long id) {
        //find the post by its id
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        entity.setViews(entity.getViews() + 1); //add view if we find it

        return new PostResponseDTO(entity);
    }

    @Transactional
    public Page<PostListResponseDTO> findAllDesc(Pageable pageable) {
        return postRepository.findAllDesc(pageable)
                .map(PostListResponseDTO::new); //PostListResponseDTO -> Page
    }

    @Transactional
    public Page<Post> list(int page) {
        //find every post in Page with pagination option
        //8 post per 1 page
        return postRepository.findAll(PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, "id")));
    }
}
