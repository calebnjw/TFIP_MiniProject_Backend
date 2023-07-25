package tfip.miniproject.backend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tfip.miniproject.backend.models.Post;

public class PostRowMapper implements RowMapper<Post> {

  @Override
  public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
    Post post = new Post();

    post.setPost_id(rs.getString("id"));
    post.setUser_id(rs.getString("user_id"));
    post.setPost_date(rs.getTimestamp("post_date").toLocalDateTime());
    post.setPost_content(rs.getString("post_content"));
    post.setImage_url(rs.getString("image_url"));

    return post;
  }
}