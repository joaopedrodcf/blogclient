package com.infinitymaze.blogclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.infitymaze.application.posts.EnumPostType;
import com.infitymaze.application.posts.Post;

public class BlogClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/post/";

	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		
		List<Post> posts = new ArrayList<Post>();
		posts.add(new Post("Manga","This is a content about manga",EnumPostType.IMPORTANT));
		posts.add(new Post("Anime","This is a content about manga",EnumPostType.REGULAR));
		posts.add(new Post("Games","This is a content about manga",EnumPostType.FLASHNEWS));
		for(Post post : posts)		
			createPost(post);
		
		getPost(1);
		getAllPosts();
		deletePost(1);
		deleteAllPosts();
	}

	public static void getAllPosts() {
		
		Post[] posts = restTemplate.getForObject(REST_SERVICE_URI,Post[].class);
		Arrays.asList(posts);

		System.out.println("getAllPosts");

	}

	private static void deleteAllPosts() {
		restTemplate.delete(REST_SERVICE_URI);
		System.out.println("deleteAllPosts");
	}
	
	private static void deletePost(long id) {
		restTemplate.delete(REST_SERVICE_URI + id);
		System.out.println("deletePost");
	}

	private static void getPost(long id) {
		Post post = restTemplate.getForObject(REST_SERVICE_URI + id, Post.class);
		System.out.println("getPost:" + post);
	}
	
	private static void createPost(Post post) {
		restTemplate.postForLocation(REST_SERVICE_URI, post);
		System.out.println("createPost");
	}

}
