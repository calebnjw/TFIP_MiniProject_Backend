package tfip.miniproject.backend.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.miniproject.backend.models.Post;
import tfip.miniproject.backend.repositories.PostRepository;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public boolean createPost(String user_id, Post post) {
    String post_id = UUID.randomUUID().toString().substring(0, 8);
    post.setPost_id(post_id);

    if (post.getImage_url() != null) {
      System.out.println("still need to work on this.");
    }

    System.out.println("CREATING NEW POST...");
    Boolean postCreated = postRepository.createPost(user_id, post);
    System.out.println("USER CREATED: " + postCreated);

    return (postCreated);
  }

  public boolean createTextPost() {
    return true;
  }

  public boolean createImagePost() {
    return true;
  }
}
