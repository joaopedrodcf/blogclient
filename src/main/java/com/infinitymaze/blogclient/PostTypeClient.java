package com.infinitymaze.blogclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.infitymaze.application.posts.Post;
import com.infitymaze.application.types.PostType;

public class PostTypeClient {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/type/";

	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final Logger logger = LogManager.getLogger(PostTypeClient.class);
	
	
	public static void getAllPostTypes() {
		PostType[] postTypes = restTemplate.getForObject(REST_SERVICE_URI, PostType[].class);
		
		for(PostType postType: postTypes) {
			logger.info(postType);
		}

	}
	
	public static void getAllPosts() {
		PostType[] postTypes = restTemplate.getForObject(REST_SERVICE_URI, PostType[].class);
		
		for(PostType postType: postTypes) {
			logger.info(postType.getPosts());
		}

	}
	
	public static void createPostType(PostType type) {
		restTemplate.postForLocation(REST_SERVICE_URI, type);
		logger.info(type);
	}
	
	
}
