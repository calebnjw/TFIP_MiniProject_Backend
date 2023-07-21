package tfip.miniproject.backend.models;

import java.util.Date;

public class Post {
  private String user_id;
  private String post_id;
  private Date post_date;
  private String post_content;
  private String image_url;

  public Post() {
  }

  public Post(String user_id, String post_id, Date post_date, String post_content, String image_url) {
    this.user_id = user_id;
    this.post_id = post_id;
    this.post_date = post_date;
    this.post_content = post_content;
    this.image_url = image_url;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getPost_id() {
    return post_id;
  }

  public void setPost_id(String post_id) {
    this.post_id = post_id;
  }

  public Date getPost_date() {
    return post_date;
  }

  public void setPost_date(Date post_date) {
    this.post_date = post_date;
  }

  public String getPost_content() {
    return post_content;
  }

  public void setPost_content(String post_content) {
    this.post_content = post_content;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  @Override
  public String toString() {
    return "Post [user_id=" + user_id + ", post_id=" + post_id + ", post_date=" + post_date + ", post_content="
        + post_content + ", image_url=" + image_url + "]";
  }
}
