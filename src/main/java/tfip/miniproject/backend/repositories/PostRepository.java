package tfip.miniproject.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tfip.miniproject.backend.mappers.PostRowMapper;
import tfip.miniproject.backend.models.Post;

@Repository
public class PostRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Post> getPostsByUser(String user_id) {
    try {
      List<Post> posts = jdbcTemplate.query(
          PostQueries.FIND_POSTS,
          new PostRowMapper(),
          user_id);

      return posts;
    } catch (Exception e) {
      // user does not exist
      return null;
    }
  }

  public Boolean createPost(String user_id, Post post) {
    try {
      Integer postRowsUpdated = jdbcTemplate.update(
          PostQueries.CREATE_POST,
          user_id,
          post.getPost_id(),
          post.getPost_content(),
          (post.getImage_url() == null ? "" : post.getImage_url()));

      return (postRowsUpdated == 1);
    } catch (Exception e) {
      // user does not exist
      System.out.println(e.getMessage());
      return false;
    }
  }

  public Boolean deletePost(String user_id, String post_id) {
    try {
      List<Post> posts = jdbcTemplate.query(
          PostQueries.VERIFY_DELETE,
          new PostRowMapper(),
          user_id,
          post_id);
      // check that only one post is getting deleted
      if (posts.size() > 1) {
        return false;
      }

      Integer postRowsUpdated = jdbcTemplate.update(
          PostQueries.DELETE_POST,
          user_id,
          post_id);

      return (postRowsUpdated == 1);
    } catch (Exception e) {
      // user does not exist
      System.out.println(e.getMessage());
      return false;
    }
  }
}
