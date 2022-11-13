package com.jiwoo1.domain.post;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super("Could not find post " + id);
    } //Exception message
}
