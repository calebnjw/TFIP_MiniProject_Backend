package tfip.miniproject.backend.controllers;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import tfip.miniproject.backend.models.Post;
import tfip.miniproject.backend.services.PostService;

@RestController
@RequestMapping(path = "/api/post")
@CrossOrigin(origins = "*")
public class PostController {

  @Autowired
  public PostService postService;

  @GetMapping(path = "/find/{post_id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> getPost(@RequestParam String post_id) {
    return null;
  }

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> createPost(@RequestBody String payload) {
    System.out.println("CREATING POST OBJECT");
    JsonObject jsonObject = Json.createReader(new StringReader(payload)).readObject();

    Post post = new Post();
    post.setPost_content(jsonObject.getString("post_content"));

    // Boolean postCreated = postService.createPost(post);
    Boolean postCreated = true;

    if (postCreated) {
      return ResponseEntity.status(HttpStatus.ACCEPTED)
          .contentType(MediaType.APPLICATION_JSON)
          .body(
              Json.createObjectBuilder()
                  .add("postCreated", true)
                  .build().toString());
    }
    return null;
  }

  @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> deletePost() {
    return null;
  }

}
