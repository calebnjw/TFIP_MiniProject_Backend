package tfip.miniproject.backend.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import tfip.miniproject.backend.models.Post;
import tfip.miniproject.backend.repositories.PostRepository;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  @Transactional(rollbackFor = IOException.class)
  public boolean createPost(String user_id, Post post, MultipartFile image) {

    System.out.println("still need to work on this.");

    return false;
  }

  public boolean createPost(String user_id, Post post) {
    String post_id = UUID.randomUUID().toString().substring(0, 8);
    post.setPost_id(post_id);

    System.out.println("CREATING NEW POST...");
    Boolean postCreated = postRepository.createPost(user_id, post);
    System.out.println("POST CREATED: " + postCreated);

    return (postCreated);
  }

  public boolean createTextPost() {
    return true;
  }

  public boolean createImagePost() {
    return true;
  }
}
