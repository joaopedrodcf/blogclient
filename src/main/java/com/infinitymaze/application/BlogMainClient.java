package com.infinitymaze.application;


import com.infinitymaze.application.entities.Post;
import com.infinitymaze.application.entities.Type;
import com.infinitymaze.blogclient.CRUDClient;


public class BlogMainClient {
	

	public static final String POST_URI = "http://localhost:8080/post/";

	public static final String TYPE_URI = "http://localhost:8080/type/";
	
	public static Type important = new Type(1, "Important");
	public static Post post1 = new Post("Lorem ipsum.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut dignissim blandit mauris, has egestas nibh efficitur at. Potentially suspend Ut.",
			important,
			"https://images.unsplash.com/photo-1464983953574-0892a716854b?ixlib=rb-0.3.5&s=e6075ab276e38b517ed3e3f28801ff2a&auto=format&fit=crop&w=1350&q=80",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper vulputate justo, et efficitur eros venenatis in. Phasellus euismod tristique nibh quis rutrum. Mauris id mi a nisl molestie porta id non dolor. Aliquam erat volutpat. Vestibulum auctor, sapien quis ornare iaculis, velit est vestibulum justo, ut pellentesque orci felis nec purus. In hac habitasse platea dictumst. Nulla aliquam imperdiet tortor, sed aliquet erat consequat id. Interdum et malesuada fames ac ante ipsum primis in faucibus.");

	public static Type curiosity = new Type(2, "Curiosity");
	public static Post post2 = new Post("Phasellus ullamcorper",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ex nibh, pharetra at efficitur sed, viverra at nulla. Aenean tincidunt.",
			curiosity,
			"https://images.unsplash.com/photo-1465101011108-4894b8cf5ec9?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=a69116e0b7db7604e11cdbcd8a1a872a&auto=format&fit=crop&w=1350&q=80",
			"Integer velit magna, laoreet non augue nec, scelerisque sodales tortor. Curabitur auctor consequat egestas. Suspendisse potenti. Cras sit amet purus non risus faucibus imperdiet. Sed vestibulum nisi quis magna auctor pretium. Praesent cursus fermentum dui eu ullamcorper. Mauris lectus dui, iaculis ut eros sit amet, ullamcorper ullamcorper dolor. Vestibulum vel arcu varius, tempor mi vel, finibus purus. Cras non urna a ligula viverra elementum vel vel purus. Cras luctus est dapibus eros finibus, id luctus nisi finibus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam ac vestibulum ligula. Sed in nulla id eros mollis dictum eu ut justo. Aliquam tortor dui, bibendum quis laoreet ac, cursus nec dui. Nam in massa felis.");

	public static Type general = new Type(3, "General");
	public static Post post3 = new Post("Quisque vitae",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ut velit in ante porttitor pharetra. Etiam dui purus, ullamcorper in.",
			general,
			"https://images.unsplash.com/photo-1490791539531-102a1e0beb7b?ixlib=rb-0.3.5&s=b36bb373e9964f7c774540a710757f1e&auto=format&fit=crop&w=1350&q=80","Curabitur efficitur nunc nec magna rhoncus bibendum. Proin ut metus vitae massa molestie laoreet. Suspendisse id accumsan ex. Sed ullamcorper et lectus a pulvinar. Donec volutpat erat et sapien interdum, sed rhoncus urna vehicula. In aliquam posuere mi, et molestie urna malesuada vel. Sed pulvinar felis sit amet volutpat ultricies. Praesent vitae arcu nunc.");

	public static Type games = new Type(4, "Games");
	public static Post post4 = new Post("Nulla at ante",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel metus sapien. Donec purus diam, eleifend vitae posuere et, convallis.",
			games,
			"https://images.unsplash.com/photo-1469053913977-1d2f009670d9?ixlib=rb-0.3.5&s=07c241405de8565010e0e958e212469e&auto=format&fit=crop&w=1355&q=80","Donec tincidunt nibh velit, at vulputate felis facilisis ac. Nam aliquam nibh id auctor tincidunt. Integer dignissim risus commodo ante elementum, ac placerat augue tristique. In iaculis laoreet sapien ac maximus. Morbi tortor lorem, malesuada nec dui a, congue faucibus magna. Nulla sodales augue eget nisi blandit placerat. Curabitur viverra ligula in cursus scelerisque. In eu leo et sapien imperdiet luctus.");

	
	public static void main(String[] args) {
		
		
		
		CRUDClient<Post> postClient = new CRUDClient<Post>(POST_URI,Post.class, Post[].class);
		CRUDClient<Type> typeClient = new CRUDClient<Type>(TYPE_URI,Type.class, Type[].class);
		
		typeClient.create(important);
		typeClient.create(curiosity);
		typeClient.create(general);
		typeClient.create(games);
		
		postClient.create(post1);
		postClient.create(post2);
		postClient.create(post3);
		postClient.create(post4);
	}
}
