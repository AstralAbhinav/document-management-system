package com.document.demo.feignClient;

import org.springframework.web.bind.annotation.PostMapping;

import com.document.demo.model.Comments;
import com.document.demo.model.Post;

@org.springframework.cloud.openfeign.FeignClient(name="feignClient", url="https://jsonplaceholder.typicode.com")		
public interface FeignClient {
	
	@PostMapping("/api")
	public Post createPost(Post post);
	
	@PostMapping("/api/comment")
	public Comments createComment(Comments comment);



	
}
