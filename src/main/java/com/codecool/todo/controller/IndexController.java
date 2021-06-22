package com.codecool.todo.controller;

import com.codecool.todo.model.Status;
import com.codecool.todo.model.Todo;
import com.codecool.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {


    @Autowired
    private final TodoService todoService;

    private static final String SUCCESS = "{\"success\":true}"; // response

    public IndexController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("list")
    @ResponseBody
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping( "addTodo")
    @ResponseBody
    public String addTodo(@RequestParam("todo-title") String todoTitle) {
        Status status = Status.ACTIVE; // default status is ACTIVE

        Todo todo = Todo.builder()
                .title(todoTitle)
                .status(status)
                .build();

        todoService.addTodo(todo);

        return SUCCESS;
    }

    @PutMapping("todos/toggle_all")
    @ResponseBody
    public String toggleAll() {
        todoService.toggleAll();
        return SUCCESS;
    }

    @DeleteMapping("todos/{id}")
    @ResponseBody
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return SUCCESS;
    }
}
