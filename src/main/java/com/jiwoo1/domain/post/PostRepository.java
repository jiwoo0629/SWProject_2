package com.jiwoo1.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



//Create CRUD method automatically
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p ORDER BY p.id DESC") //Query
    Page<Post> findAllDesc(Pageable pageable); //Find every post in postRepository and make it into Page<post>


}
