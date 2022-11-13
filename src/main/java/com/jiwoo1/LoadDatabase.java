package com.jiwoo1;

import com.jiwoo1.domain.post.Post;
import com.jiwoo1.domain.post.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    //initialization of database
    CommandLineRunner initDatabase(PostRepository repository) {
        return args -> {
            for(int i=1; i<101; i++) {
                String title = "제목" + Integer.toString(i);
                String content = "내용" + Integer.toString(i);
                log.info(" " + repository.save(new Post(title, content)));
            }
        };
    }

}
