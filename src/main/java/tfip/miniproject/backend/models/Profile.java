package tfip.miniproject.backend.models;

import jakarta.json.Json;
import jakarta.json.JsonValue;

public class Profile {
  private String user_id;
  private String display_name;
  private String status_message;
  private String user_location;
  private String profile_img;

  public Profile() {
  }

  public Profile(String user_id, String display_name, String status_message, String user_location,
      String profile_img) {
    this.user_id = user_id;
    this.display_name = display_name;
    this.status_message = status_message;
    this.user_location = user_location;
    this.profile_img = profile_img;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
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

  public JsonValue toJson() {
    return Json.createObjectBuilder()
        .add("display_name", this.getDisplay_name())
        .add("status_message", this.getStatus_message())
        .add("user_location", this.getUser_location())
        .add("profile_img", this.getProfile_img())
        .build();
  }

  @Override
  public String toString() {
    return "Profile [user_id=" + user_id + ", display_name=" + display_name + ", status_message=" + status_message
        + ", user_location=" + user_location + ", profile_img=" + profile_img + "]";
  }

}
