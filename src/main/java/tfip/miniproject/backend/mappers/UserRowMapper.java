package tfip.miniproject.backend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tfip.miniproject.backend.models.User;

public class UserRowMapper implements RowMapper<User> {

  User user = new User();

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    user.setUser_id(rs.getString("id"));
    user.setUsername(rs.getString("username"));
    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));

    return user;
  }
}
