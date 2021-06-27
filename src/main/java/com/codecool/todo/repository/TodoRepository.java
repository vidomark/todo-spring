package com.codecool.todo.repository;

import com.codecool.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("SELECT  todo FROM Todo todo WHERE (:status = ''  OR LOWER(todo.status) = :status) ")
    List<Todo> getTodosByStatus(@Param("status") String status);

    @Query("UPDATE Todo todo SET todo.status = " +
                "CASE WHEN todo.status = 'COMPLETE' THEN 'ACTIVE' " +
                "ELSE 'COMPLETE' " +
                "END ")
    @Modifying(clearAutomatically = true)
    void toggleAll();

    @Query("DELETE FROM Todo todo WHERE todo.status = 'COMPLETE' ")
    @Modifying(clearAutomatically = true)
    void deleteCompleted();

    @Query("UPDATE Todo todo SET todo.status = CASE WHEN todo.status = 'COMPLETE' THEN 'ACTIVE' ELSE 'COMPLETE' END WHERE todo.id = :id")
    @Modifying(clearAutomatically = true)
    void toggleTodo(@Param("id") int id);

    @Query("UPDATE Todo todo SET todo.title = :title WHERE todo.id = :id")
    @Modifying(clearAutomatically = true)
    void updateTodo(@Param("id") int id, @Param("title") String title);
}
