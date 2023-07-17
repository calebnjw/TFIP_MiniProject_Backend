package tfip.miniproject.backend.models;

public class Profile {
  private String profile_id;
  private String display_name;
  private String status_message;
  private String user_location;
  private String profile_img;

  public Profile() {
  }

  public Profile(String profile_id, String display_name, String status_message, String user_location,
      String profile_img) {
    this.profile_id = profile_id;
    this.display_name = display_name;
    this.status_message = status_message;
    this.user_location = user_location;
    this.profile_img = profile_img;
  }

  public String getProfile_id() {
    return profile_id;
  }

  public void setProfile_id(String profile_id) {
    this.profile_id = profile_id;
  }

  public String getDisplay_name() {
    return display_name;
  }

  public void setDisplay_name(String display_name) {
    this.display_name = display_name;
  }

  public String getStatus_message() {
    return status_message;
  }

  public void setStatus_message(String status_message) {
    this.status_message = status_message;
  }

  public String getUser_location() {
    return user_location;
  }

  public void setUser_location(String user_location) {
    this.user_location = user_location;
  }

  public String getProfile_img() {
    return profile_img;
  }

  public void setProfile_img(String profile_img) {
    this.profile_img = profile_img;
  }

  @Override
  public String toString() {
    return "Profile [profile_id=" + profile_id + ", display_name=" + display_name + ", status_message=" + status_message
        + ", user_location=" + user_location + ", profile_img=" + profile_img + "]";
  }

}
