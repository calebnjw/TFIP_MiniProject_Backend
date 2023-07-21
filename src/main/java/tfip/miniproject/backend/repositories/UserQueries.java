package tfip.miniproject.backend.repositories;

public class UserQueries {

  // select queries
  public static final String FIND_USER = "SELECT * FROM users WHERE UPPER(username) = UPPER(?)";
  public static final String FIND_EMAIL = "SELECT * FROM users WHERE UPPER(email) = UPPER(?)";
  public static final String FIND_PROFILE = "SELECT * FROM profiles LEFT JOIN users ON users.id = profiles.user_id WHERE username = ?";

  // insert queries
  public static final String CREATE_USER = "INSERT INTO users (id, username, email, password) VALUES (?, ?, ?, ?)";
  public static final String CREATE_PROFILE = "INSERT INTO profiles (user_id) VALUES (?)";

  // update queries

  // delete queries
}
