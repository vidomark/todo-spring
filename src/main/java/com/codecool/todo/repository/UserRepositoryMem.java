package com.codecool.todo.repository;

import com.codecool.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepositoryMem implements UserRepository {

    private final Set<User> users;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepositoryMem(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        users = Set.of(
                new User("user1", passwordEncoder.encode("password"), null, true, true, true, true),
                new User("user2", passwordEncoder.encode("password"), null, true, true, true, true),
                new User("user3", passwordEncoder.encode("password"), null, true, true, true, true)
        );
    }

    @Override
    public Optional<User> loadUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }
}
