package tfip.miniproject.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tfip.miniproject.backend.mappers.ProfileRowMapper;
import tfip.miniproject.backend.mappers.UserRowMapper;
import tfip.miniproject.backend.models.Profile;
import tfip.miniproject.backend.models.User;

@Repository
public class UserRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public User findUser(String username) {
    try {
      User user = jdbcTemplate.queryForObject(Queries.FIND_USER, new UserRowMapper(), new Object[] { username });
      return user;
    } catch (Exception e) {
      // user does not exist
      return null;
    }
  }

  public User findEmail(String email) {
    try {
      User user = jdbcTemplate.queryForObject(Queries.FIND_EMAIL, new UserRowMapper(), new Object[] { email });
      return user;
    } catch (Exception e) {
      // user does not exist
      return null;
    }
  }

  public Profile findProfile(String user_id) {
    try {
      Profile profile = jdbcTemplate.queryForObject(Queries.FIND_PROFILE, new ProfileRowMapper(),
          new Object[] { user_id });
      return profile;
    } catch (Exception e) {
      // user does not exist
      return null;
    }
  }

  public Boolean createUser(User user) {
    try {
      Integer userRowsUpdated = jdbcTemplate
          .update(Queries.CREATE_USER, user.getUsername(), user.getEmail(),
              user.getPassword());
      // should create a single row
      return (userRowsUpdated == 1);
    } catch (Exception e) {
      // failed to create user
      System.out.println(e.getMessage());
      return false;
    }
  }

  public Boolean createProfile(String user_id) {
    try {
      Integer profileRowsUpdated = jdbcTemplate
          .update(Queries.CREATE_PROFILE, user_id);
      return (profileRowsUpdated == 1);
    } catch (Exception e) {
      // failed to create profile
      System.out.println(e.getMessage());
      return false;
    }
  }
}
