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

  public boolean createUser(User user) {
    // check for existing user
    String username = user.getUsername();
    String email = user.getEmail();

    if (checkUsernameExist(username) || checkEmailExist(email)) {
      // failed to create user
      System.out.println("USERNAME OR EMAIL ALREADY IN USE.");
      return false;
    }

    String user_id = UUID.randomUUID().toString().substring(0, 8);
    user.setUser_id(user_id);

    System.out.println("CREATING NEW USER...");
    Boolean userCreated = userRepository.createUser(user);
    System.out.println("USER CREATED: " + userCreated);
    Boolean profileCreated = userRepository.createProfile(user_id);
    System.out.println("PROFILE CREATED: " + profileCreated);

    return (userCreated && profileCreated);
  }

  public User loginUser(User user) {
    String username = user.getUsername();
    String password = user.getPassword();

    User userLookup = findUser(username);
    if (userLookup.getPassword() == password) {
      System.out.println("USERNAME AND PASSWORD MATCH.");
      // look for user and profile information

      // then update user object
      user.setUser_id(userLookup.getUser_id());
      user.setEmail(userLookup.getEmail());
      user.setProfile();

      // return user object
    }

    return user;
  }

  // utilities
  public Profile findProfile(String user_id) {
    Profile profile = userRepository.findProfile(user_id);
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
