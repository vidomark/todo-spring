package com.codecool.todo.repository;

import com.codecool.todo.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> loadUserByUsername(String username);
}
