package com.codecool.todo.service;

import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodosByStatus(String status) {
        return todoRepository.getTodosByStatus(status);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void toggleAll() {
        todoRepository.toggleAll();
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    public void deleteCompleted() {
        todoRepository.deleteCompleted();
    }

    public void toggleTodo(int id) {
        todoRepository.toggleTodo(id);
    }

    public void updateTodo(int id, String title) {
        todoRepository.updateTodo(id, title);
    }
}
