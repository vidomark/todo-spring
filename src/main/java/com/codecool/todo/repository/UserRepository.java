package com.codecool.todo.repository;

import com.codecool.todo.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserRepository {

    Optional<User> loadUserByUsername(String username);

    Set<User> getUsers();
}
