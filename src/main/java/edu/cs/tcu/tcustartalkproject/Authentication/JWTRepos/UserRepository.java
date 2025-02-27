package edu.cs.tcu.tcustartalkproject.Authentication.JWTRepos;

import java.util.Optional;

import edu.cs.tcu.tcustartalkproject.Authentication.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findByEmail(String email);
    User findByToken(String token);
}