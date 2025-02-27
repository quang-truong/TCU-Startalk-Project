package edu.cs.tcu.tcustartalkproject.Authentication.JWTRepos;

import com.google.rpc.context.AttributeContext;
import edu.cs.tcu.tcustartalkproject.Authentication.Models.User;
import edu.cs.tcu.tcustartalkproject.Course.Course;
import edu.cs.tcu.tcustartalkproject.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.UUID;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    /**
     * Repository for basic operations: findAll(), findById(), delete(), save(), update()
     */
    private final UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method to query all chapters in a book.
     * @return List of found chapters.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Method to query one chapter by index.
     * @param id index of the chapter to be sought.
     * @return Chapter to be sought.
     */
    public User findById(final String id) {
        return userRepository.findById(id).get();
    }

    /**
     * Method to delete one chapter by index.
     * @param id index of the chapter to be deleted.
     */
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) { return userRepository.findByEmail(email); }

    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
/*
    public String forgotPassword(String email) {

        Optional<User> userOptional = Optional
                .ofNullable(userRepository.findByEmail(email));

        if (!userOptional.isPresent()) {
            return "Invalid email id.";
        }

        User user = userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepository.save(user);

        return user.getToken();
    }

    public String resetPassword(String token, String password) {

        Optional<User> userOptional = Optional
                .ofNullable(userRepository.findByToken(token));

        if (!userOptional.isPresent()) {
            return "Invalid token.";
        }

        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Expired token.";

        }

        User user = userOptional.get();
        encoder.encode(password);
        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);

        userRepository.save(user);
        System.out.println("success update");

        return "Your password successfully updated.";
    }
*/
    /**
     * Generate unique token. You may add multiple parameters to create a strong
     * token.
     *
     * @return unique token
     */

    /*
    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }
*/
    /**
     * Check whether the created token expired or not.
     *
     * @param tokenCreationDate
     * @return true or false
     */
    /*
    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
    */
}