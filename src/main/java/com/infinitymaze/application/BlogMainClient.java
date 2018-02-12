package com.infinitymaze.application;

import java.util.ArrayList;
import java.util.List;

import com.infinitymaze.blogclient.PostClient;
import com.infitymaze.application.posts.EnumPostType;
import com.infitymaze.application.posts.Post;

public class BlogMainClient {
	
	// Objects to be used in the tests
	private static Post manga = new Post("Manga", "This is a content about manga", EnumPostType.IMPORTANT);
	private static Post anime = new Post("Anime", "This is a content about manga", EnumPostType.REGULAR);
	private static Post games = new Post("Games", "This is a content about manga", EnumPostType.FLASHNEWS);
	private static Post book = new Post("Book", "This is a content about book", EnumPostType.IMPORTANT);
	private static Post bd = new Post("Bd", "This is a content about bd", EnumPostType.REGULAR);
	
	public static void main(String[] args) {
		// create Posts
		List<Post> posts = new ArrayList<Post>();
		posts.add(manga);
		posts.add(anime);
		posts.add(games);
		for (Post post : posts)
			PostClient.createPost(post);

		PostClient.getPost(1);
		PostClient.getAllPosts();
		PostClient.deletePost(1);
		PostClient.deleteAllPosts();

		PostClient.createPost(book);

		PostClient.updatePost(book.getId(), bd);
	}
	

}
