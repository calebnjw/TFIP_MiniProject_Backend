package tfip.miniproject.backend.controllers;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import tfip.miniproject.backend.models.User;
import tfip.miniproject.backend.services.UserService;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(path = "/find/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> findUsername(@PathVariable String username) {
    System.out.println("CHECKING USERNAME");
    Boolean userExists = userService.checkUsernameExist(username);
    System.out.println(userExists);
    return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            Json.createObjectBuilder()
                .add("userExists", userExists)
                .build().toString());
  }

  @GetMapping(path = "/find/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> findEmail(@PathVariable String email) {
    System.out.println("CHECKING EMAIL");
    Boolean userExists = userService.checkEmailExist(email);
    System.out.println(userExists);
    return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            Json.createObjectBuilder()
                .add("userExists", userExists)
                .build().toString());
  }

  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> loginUser(@RequestBody String payload) {
    System.out.println("CREATING USER OBJECT");
    JsonObject jsonObject = Json.createReader(new StringReader(payload)).readObject();

    // userlogin stuff
    User user = new User(
        jsonObject.getString("username"),
        jsonObject.getString("password"));
    User verifiedUser = userService.loginUser(user);

    if (verifiedUser != null) {
      return ResponseEntity.status(HttpStatus.ACCEPTED)
          .contentType(MediaType.APPLICATION_JSON)
          .body(
              Json.createObjectBuilder()
                  .add("userLogin", true)
                  .add("user", verifiedUser.toJson())
                  .build().toString());

    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            Json.createObjectBuilder()
                .add("error", "INVALID USERNAME OR PASSWORD.")
                .build().toString());
  }

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> createUser(@RequestBody String payload) {
    System.out.println("CREATING USER OBJECT");
    JsonObject jsonObject = Json.createReader(new StringReader(payload)).readObject();

    User user = new User(
        jsonObject.getString("username"),
        jsonObject.getString("email"),
        jsonObject.getString("password"));
    User userCreated = userService.createUser(user);

    if (userCreated != null) {
      return ResponseEntity.status(HttpStatus.ACCEPTED)
          .contentType(MediaType.APPLICATION_JSON)
          .body(
              Json.createObjectBuilder()
                  .add("userLogin", true)
                  .add("user", userCreated.toJson())
                  .build().toString());

    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            Json.createObjectBuilder()
                .add("error", "USERNAME OR EMAIL IS ALREADY IN USE.")
                .build().toString());
  }

  @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> updateUser() {
    return null;
  }

  @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> deleteUser() {
    return null;
  }
}
