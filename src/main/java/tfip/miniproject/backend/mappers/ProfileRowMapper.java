package tfip.miniproject.backend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tfip.miniproject.backend.models.Profile;

public class ProfileRowMapper implements RowMapper<Profile> {

  Profile profile = new Profile();

  @Override
  public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
    profile.setUser_id(rs.getString("user_id"));
    profile.setDisplay_name(rs.getString("display_name"));
    profile.setStatus_message(rs.getString("status_message"));
    profile.setUser_location(rs.getString("user_location"));
    profile.setProfile_img(rs.getString("profile_img"));

    return profile;
  }
}
