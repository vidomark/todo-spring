package com.codecool.todo.repository;

import com.codecool.todo.model.Status;
import com.codecool.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("UPDATE Todo todo SET todo.status = " +
            "CASE WHEN todo.status = 'COMPLETE' THEN 'ACTIVE' " +
            "ELSE 'COMPLETE' " +
            "END ")
    @Modifying(clearAutomatically = true)
    void toggleAll();
}
