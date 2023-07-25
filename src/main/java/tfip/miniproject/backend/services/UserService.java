package tfip.miniproject.backend.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.miniproject.backend.models.Profile;
import tfip.miniproject.backend.models.User;
import tfip.miniproject.backend.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User createUser(User user) {
    // check for existing user
    String username = user.getUsername();
    String email = user.getEmail();

    if (checkUsernameExist(username) || checkEmailExist(email)) {
      // failed to create user
      System.out.println("USERNAME OR EMAIL ALREADY IN USE.");
      return null;
    }

    System.out.println("CREATING NEW USER...");
    String userId = UUID.randomUUID().toString().substring(0, 8);
    user.setUser_id(userId);
    Boolean userCreated = userRepository.createUser(user);
    System.out.println("USER CREATED: " + userCreated);
    Boolean profileCreated = userRepository.createProfile(userId);
    System.out.println("PROFILE CREATED: " + profileCreated);

    if (userCreated && profileCreated) {
      Profile userProfile = findProfile(username);
      user.setProfile(userProfile);
      return user;
    }

    return null;
  }

  public User loginUser(User user) {
    String username = user.getUsername();
    String password = user.getPassword();

    User userLookup = findUser(username);
    if (userLookup.getPassword().equalsIgnoreCase(password)) {
      System.out.println("USER FOUND.");
      System.out.println("USERNAME AND PASSWORD MATCH.");

      // look for user and profile information
      Profile userProfile = findProfile(username);

      // then update user object
      user.setUser_id(userLookup.getUser_id());
      user.setEmail(userLookup.getEmail());
      user.setPassword("");
      user.setProfile(userProfile);
      System.out.println("USER: " + user.toString());
      System.out.println("UPDATED PROFILE: " + user.getProfile());

      // return user object
      return user;
    } else {
      return null;
    }

  }

  // utilities
  public Profile findProfile(String username) {
    Profile profile = userRepository.findProfile(username);
    return profile;
  }

  public Boolean checkUsernameExist(String username) {
    // return true if exists
    return (findUser(username) != null);
  }

  public Boolean checkEmailExist(String email) {
    // return true if exists
    return (findEmail(email) != null);
  }

  public User findUser(String username) {
    User user = userRepository.findUser(username);
    return user;
  }

  public User findEmail(String email) {
    User user = userRepository.findEmail(email);
    return user;
  }
}
