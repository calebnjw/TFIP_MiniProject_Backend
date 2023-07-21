package tfip.miniproject.backend.repositories;

public class Queries {

  // select queries
  public static final String FIND_USER = "SELECT * FROM users WHERE UPPER(username) = UPPER(?)";
  public static final String FIND_EMAIL = "SELECT * FROM users WHERE UPPER(email) = UPPER(?)";
  public static final String FIND_PROFILE = "SELECT * FROM profiles WHERE user_id = ?";
  public static final String FIND_POSTS = "SELECT * FROM posts WHERE user_id = ?";

  // insert queries
  public static final String CREATE_USER = "INSERT INTO users (id, username, email, password) VALUE (?, ?, ?, ?)";
  public static final String CREATE_PROFILE = "INSERT INTO profiles (user_id) VALUE (?)";

  // update queries

  // delete queries
}
