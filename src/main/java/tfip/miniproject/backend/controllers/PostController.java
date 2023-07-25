package tfip.miniproject.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.json.Json;
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

  @GetMapping(path = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> getAllPosts() {
    System.out.println("PULLING POSTS");

    // TODO:
    // call post service to find all posts

    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            Json.createObjectBuilder()
                .add("postCreated", true)
                .build().toString());
  }

  @PostMapping(path = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> createPost(
      @RequestPart(required = true) String post_content, @RequestPart(required = false) MultipartFile image) {
    System.out.println("CREATING POST OBJECT");

    String postContent = post_content;
    MultipartFile postImage = image;

    Boolean postCreated = false;

    System.out.println("CONTENT: " + postContent);
    System.out.println("IMAGE: " + postImage);

    // TODO:
    // FUNCTION TO CREATE POSTS IN POST SERVICE DATA PASSED HERE.
    // if post has image data attached, need to upload image to s3 first
    // then take url from s3 and save it to post table with post data

    if (image == null) {
      postCreated = postService.createPost();
    }

    if (postCreated) {
      return ResponseEntity.status(HttpStatus.ACCEPTED)
          .contentType(MediaType.APPLICATION_JSON)
          .body(
              Json.createObjectBuilder()
                  .add("postCreated", true)
                  .build().toString());
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            Json.createObjectBuilder()
                .add("error", "FAILED TO CREATE POST.")
                .build().toString());
  }

  @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> deletePost() {
    return null;
  }

}
