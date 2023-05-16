package com.document.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.document.demo.Service.DocumentService;
import com.document.demo.model.Post;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DocumentService documentService;
	
	@Test
	void createPost() {
		Post post = Post.builder().content("first post using feign client").documentId(1).title("pdf post").build();
		Post newPost =documentService.createPost(post);
		
		System.out.println("new post created" +newPost);
	}	
}
