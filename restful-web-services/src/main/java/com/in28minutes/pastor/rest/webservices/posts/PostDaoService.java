package com.in28minutes.pastor.rest.webservices.posts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.pastor.rest.webservices.user.User;

@Component
public class PostDaoService {

	private static List<Post> posts = new ArrayList<>();

	private static int postCount = 5;

	static {
		User maciek = new User(1, "Maciek", new Date());
		User marta = new User(2, "Marta", new Date());
		User patryk = new User(3, "Patryk", new Date());

		posts.add(new Post(1, patryk.getId(), new Date(), "Post1"));
		posts.add(new Post(2, marta.getId(), new Date(), "Post2"));
		posts.add(new Post(3, marta.getId(), new Date(), "Post3"));
		posts.add(new Post(4, patryk.getId(), new Date(), "Post4"));
		posts.add(new Post(5, maciek.getId(), new Date(), "Post5"));
	}

	public List<Post> findAllUserPosts(int userId) {
		List<Post> userPosts = new ArrayList<>();
		for (Post post : posts) {
			if (post.getUserId() == userId) {
				userPosts.add(post);
			}
		}
		return userPosts;
	}

	public Post createPostForUser(Post post) {
		if (post.getId() == null) {
			post.setId(++postCount);
		}
		posts.add(post);
		return post;
	}

	public Post retrieveDetailsOfThePost(int postId) {
		for (Post post : posts) {
			if (post.getId() == postId) {
				return post;
			}
		}
		return null;
	}

}
