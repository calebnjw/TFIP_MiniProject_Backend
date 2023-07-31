package tfip.miniproject.backend.services;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
  public boolean createPost(String userId, Post post, MultipartFile image) {

    System.out.println("still need to work on this.");

    return false;
  }

  public boolean createPost(String userId, String post_content) {
    System.out.println("CREATING NEW POST...");
    String postId = UUID.randomUUID().toString().substring(0, 8);

    Post post = new Post();
    post.setUser_id(userId);
    post.setPost_id(postId);
    post.setPost_content(post_content);

    Boolean postCreated = postRepository.createPost(userId, post);
    System.out.println("POST CREATED: " + postCreated);

    return (postCreated);
  }

  public Post getSinglePost(String postId) {
    System.out.println("FINDING POSTS...");
    Post post = new Post();

    post = postRepository.getSinglePost(postId);
    if (post != null) {
      return post;
    }

    return null;
  }

  public List<Post> getPosts(String userId) {
    System.out.println("FINDING POSTS...");
    List<Post> posts = new LinkedList<Post>();

    posts = postRepository.getPostsByUser(userId);
    if (posts != null) {
      return posts;
    }

    return null;
  }
}
