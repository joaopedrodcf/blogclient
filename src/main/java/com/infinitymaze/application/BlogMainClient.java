package com.infinitymaze.application;


import java.util.Arrays;

import com.infinitymaze.blogclient.PostClient;
import com.infinitymaze.blogclient.PostTypeClient;
import com.infitymaze.application.posts.Post;
import com.infitymaze.application.types.PostType;

public class BlogMainClient {
	
	// Objects to be used in the tests

	
	public static void main(String[] args) {
		
		PostTypeClient.getAllPostTypes();
		
		PostType important = new PostType(1, "Important");
		PostType regular = new PostType(2, "Regular");
		
		Post anime = new Post("Anime", "This is a content about anime",important);
		Post book = new Post("Book", "This is a content about book",regular);
		
		important.addPost(anime);
		regular.addPost(book);
		
		PostTypeClient.createPostType(important);
		PostTypeClient.createPostType(regular);
		PostTypeClient.getAllPostTypes();
		PostTypeClient.getAllPosts();
	}
}
