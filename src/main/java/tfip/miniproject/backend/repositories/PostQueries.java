package tfip.miniproject.backend.repositories;

public class PostQueries {

  // select queries
  public static final String FIND_POSTS = "SELECT * FROM posts WHERE user_id = ?";
  public static final String VERIFY_DELETE = "SELECT * FROM posts WHERE user_id = ? AND id = ?";

  // insert queries
  public static final String CREATE_POST = "INSERT INTO posts ( user_id, id, post_content, image_url) VALUE (?, ?, ?, ?)";

  // delete queries
  public static final String DELETE_POST = "DELETE FROM posts WHERE user_id = ? AND id = ?";
}
