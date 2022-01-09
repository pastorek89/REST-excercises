package com.in28minutes.pastor.rest.webservices.posts;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.pastor.rest.webservices.user.User;
import com.in28minutes.pastor.rest.webservices.user.UserDaoService;
import com.in28minutes.pastor.rest.webservices.user.UserNotFoundException;

@RestController
public class PostResources {

	@Autowired
	private PostDaoService service;
	
	@Autowired
	private UserDaoService userService;
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getAllPostFromUser(@PathVariable int id) {
		User user = userService.findUser(id);
		 if (user == null) {
			 throw new UserNotFoundException("id = " + id + " User doesn't exist");
		 }
		return service.findAllUserPosts(id);
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createUser(@RequestBody Post post) {
		Post createdPost = service.createPostForUser(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdPost.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public Post retrieveDetailFromPostFromUser(@PathVariable int id, @PathVariable int post_id) {
		User user = userService.findUser(id);
		if (user == null) {
			 throw new UserNotFoundException("id = " + id + " User doesn't exist");
		 }
		Post post = service.retrieveDetailsOfThePost(post_id);
		if (post == null) {
			throw new PostNotFoundException("id = " + post_id + " Post doesn't exist");
		}
		return post;
	}
}
