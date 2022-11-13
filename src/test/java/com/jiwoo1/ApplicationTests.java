package com.jiwoo1;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import com.jiwoo1.domain.post.Post;
import com.jiwoo1.domain.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {
	PostRepository postRepository;
	@Test
	public void contextLoads() {
		//given
		String title = "제목1";
		String content = "내용1";

		postRepository.save(Post.builder()
				.title(title)
				.content(content)
				.build());

		//when
		List<Post> postList = postRepository.findAll();

		//then
		Post post = postList.get(0);
		assertThat(post.getTitle()).isEqualTo(title);
		assertThat(post.getContent()).isEqualTo(content);
	}

}
