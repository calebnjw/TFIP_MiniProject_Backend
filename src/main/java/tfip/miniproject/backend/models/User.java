package tfip.miniproject.backend.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonValue;

public class User {
  private String user_id;
  private String username;
  private String email;
  private String password;
  private Profile profile = new Profile();

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User(String user_id, String username, String email, String password) {
    this.user_id = user_id;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public static User createUserObject(SqlRowSet rs) {
    User user = new User();

    user.setUser_id(rs.getString("id"));
    user.setUsername(rs.getString("username"));
    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));

    return user;
  }

  public JsonValue toJson() {
    return Json.createObjectBuilder()
        .add("username", this.getUsername())
        .add("email", this.getEmail())
        .add("profile", this.getProfile().toJson())
        .build();
  }

  @Override
  public String toString() {
    return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
        + ", profile=" + (profile == null ? "empty profile" : profile.toString()) + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }
}
