package com.example.devops_uppg_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> addTask2(@RequestParam String task) {
        todoService.addTask(task);
        return ResponseEntity.ok("Task added!");
    }

    @PostMapping("/modify")
    public ResponseEntity<String> modifyTask(String task, int index) {
        todoService.modifyTask(task, index);
        return ResponseEntity.ok("Task modified!");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteTask(@RequestParam int index) {
        todoService.deleteTask(index);
        return ResponseEntity.ok("Task deleted!");
    }

    @GetMapping("/list")
    public List<String> listTasks() {
        return todoService.listTasks();
    }

    @GetMapping("/emptyList")
    public void emptyList() {
        todoService.emptyList();
    }
}