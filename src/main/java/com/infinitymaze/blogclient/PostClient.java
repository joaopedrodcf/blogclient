package com.infinitymaze.blogclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.infitymaze.application.posts.Post;

public class PostClient {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/post/";

	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final Logger logger = LogManager.getLogger(PostClient.class);
	
	public static void getAllPosts() {
		Post[] posts = restTemplate.getForObject(REST_SERVICE_URI, Post[].class);
		
		for(Post post: posts) {
			logger.info(post);
		}

	}

	public static void deleteAllPosts() {
		restTemplate.delete(REST_SERVICE_URI);
	}

	public static void deletePost(long id) {
		try {
			restTemplate.delete(REST_SERVICE_URI + id);
		} catch (final HttpClientErrorException e) {
			logger.info(e.getStatusCode());
			logger.info(e.getResponseBodyAsString());
		}
	}

	public static void getPost(long id) {
		try {
			ResponseEntity<Post> responseEntity = restTemplate.getForEntity(REST_SERVICE_URI + id, Post.class);
			logger.info(responseEntity.getBody());
		} catch (final HttpClientErrorException e) {
			logger.info(e.getStatusCode());
			logger.info(e.getResponseBodyAsString());
		}


	}

	public static void createPost(Post post) {
		restTemplate.postForLocation(REST_SERVICE_URI, post);
		logger.info(post);
	}

	public static void updatePost(long id, Post post) {
		try {
			restTemplate.put(REST_SERVICE_URI + id, post);
		} catch (final HttpClientErrorException e) {
			logger.info(e.getStatusCode());
			logger.info(e.getResponseBodyAsString());
		}
	}
	
}
