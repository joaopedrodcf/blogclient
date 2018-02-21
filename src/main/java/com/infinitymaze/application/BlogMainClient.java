package com.infinitymaze.application;


import com.infinitymaze.blogclient.PostClient;
import com.infitymaze.application.posts.Post;
import com.infitymaze.application.types.PostType;

public class BlogMainClient {
	
	// Objects to be used in the tests

	public static void main(String[] args) {
		
		PostType important = new PostType(1,"Important");
		PostType generic = new PostType(2,"Generic");
		PostType flash = new PostType(3,"Flash");
		
		Post manga = new Post("Manga", "This is a content about manga",important);
		Post anime = new Post("Anime", "This is a content about anime",generic);
		Post games = new Post("Games", "This is a content about games",flash);

		PostClient.createPost(manga);
		PostClient.createPost(anime);
		PostClient.createPost(games);
	
	}
}
