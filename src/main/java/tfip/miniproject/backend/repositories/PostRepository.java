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
      List<Post> posts = jdbcTemplate.query(Queries.FIND_POSTS, new PostRowMapper(), user_id);

      return posts;
    } catch (Exception e) {
      // user does not exist
      return null;
    }
  }
}
