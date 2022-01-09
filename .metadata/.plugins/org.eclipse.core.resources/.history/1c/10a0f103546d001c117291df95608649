package com.in28minutes.pastor.rest.webservices.posts;

import java.util.Date;

public class Post {

	private Integer Id;
	private Integer userId;
	private Date dateOfPost;
	private String postBody;
	//Repository name changed - commit test

	public Integer getId() {
		return Id;
	}

	public Post(Integer id, Integer userId, Date dateOfPost, String postBody) {
		super();
		Id = id;
		this.userId = userId;
		this.dateOfPost = dateOfPost;
		this.postBody = postBody;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	@Override
	public String toString() {
		return "Post [Id=" + Id + ", userId=" + userId + ", dateOfPost=" + dateOfPost + ", postBody=" + postBody + "]";
	}

}
