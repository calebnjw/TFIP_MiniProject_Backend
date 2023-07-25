package tfip.miniproject.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import tfip.miniproject.backend.mappers.PostRowMapper;
import tfip.miniproject.backend.models.Post;

@Repository
public class PostRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Post> getPostsByUser(String userId) {
    try {
      List<Post> posts = jdbcTemplate.query(
          PostQueries.FIND_POSTS,
          new PostRowMapper(),
          userId);

      return posts;
    } catch (Exception e) {
      // user does not exist
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public Boolean createPost(String userId, Post post) {
    try {
      Integer postRowsUpdated = jdbcTemplate.update(
          PostQueries.CREATE_TEXT_POST,
          userId,
          post.getPost_id(),
          post.getPost_content());

      return (postRowsUpdated == 1);
    } catch (Exception e) {
      // user does not exist
      System.out.println(e.getMessage());
      return false;
    }
  }

  public Boolean createPost(String userId, Post post, MultipartFile image) {
    try {
      Integer postRowsUpdated = jdbcTemplate.update(
          PostQueries.CREATE_IMAGE_POST,
          userId,
          post.getPost_id(),
          post.getPost_content()
      // (post.getImage_url() == null ? "" : post.getImage_url())
      );

      return (postRowsUpdated == 1);
    } catch (Exception e) {
      // user does not exist
      System.out.println(e.getMessage());
      return false;
    }
  }

  public Boolean deletePost(String userId, String post_id) {
    try {
      List<Post> posts = jdbcTemplate.query(
          PostQueries.VERIFY_DELETE,
          new PostRowMapper(),
          userId,
          post_id);
      // check that only one post is getting deleted
      if (posts.size() > 1) {
        return false;
      }

      Integer postRowsUpdated = jdbcTemplate.update(
          PostQueries.DELETE_POST,
          userId,
          post_id);

      return (postRowsUpdated == 1);
    } catch (Exception e) {
      // user does not exist
      System.out.println(e.getMessage());
      return false;
    }
  }
}
