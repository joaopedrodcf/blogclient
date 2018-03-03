package com.infinitymaze.application;


import com.infinitymaze.blogclient.CRUDClient;
import com.infitymaze.application.posts.Post;
import com.infitymaze.application.types.Type;

public class BlogMainClient {
	
	static Type important = new Type(1,"Important");
	static Type regular = new Type(2,"Regular");
	
	static Post anime = new Post("Anime", "This is a content about anime",important);
	static Post book = new Post("Book", "This is a content about book",regular);
	
	public static final String POST_URI = "http://localhost:8080/post/";

	public static final String TYPE_URI = "http://localhost:8080/type/";

	
	public static void main(String[] args) {
		
		CRUDClient<Post> postClient = new CRUDClient<Post>(POST_URI,Post.class, Post[].class);
		CRUDClient<Type> typeClient = new CRUDClient<Type>(TYPE_URI,Type.class, Type[].class);
		
		postClient.getAll();
		typeClient.getAll();
		
		typeClient.create(important);
		typeClient.create(regular);
		
		postClient.create(anime);
		postClient.create(book);
		
		postClient.getAll();
		typeClient.getAll();
		
	}
}
