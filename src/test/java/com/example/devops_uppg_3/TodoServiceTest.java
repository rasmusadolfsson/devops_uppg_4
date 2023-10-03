package com.example.devops_uppg_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TodoServiceTest {

    private final TodoService todoService = new TodoService(new ArrayList<>());

    @Test
    public void addTaskTest_ShouldAddTask() {
        todoService.addTask("test");
        Assertions.assertEquals(todoService.listTasks().get(0), "test");
    }

    @Test
    public void modifyTaskTest_ShouldModifyTask() {
        todoService.addTask("test");
        todoService.modifyTask("test2", 0);
        Assertions.assertEquals(todoService.listTasks().get(0), "test2");
    }

    @Test
    public void deleteTaskTest_ShouldDeleteTask() {
        todoService.addTask("test");
        todoService.deleteTask(0);
        Assertions.assertEquals(todoService.listTasks().size(), 0);
    }

    @Test
    public void emptyListTest_shouldEmptyList() {
        todoService.addTask("test");
        todoService.emptyList();
        Assertions.assertEquals(todoService.listTasks().size(), 0);
    }

    @Test
    public void listTasks_ShouldReturnList() {
        todoService.addTask("test");
        Assertions.assertEquals(todoService.listTasks().get(0), "test");
    }


}
