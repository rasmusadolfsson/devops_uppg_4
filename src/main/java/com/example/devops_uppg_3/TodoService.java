package com.example.devops_uppg_3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private List<String> taskList;

    public TodoService(List<String> taskList) {
        this.taskList = taskList;
    }

    public void addTask(String task) {
        taskList.add(task);

    }

    public void modifyTask(String task, int index) {
        if (index >= 0 && index < taskList.size()) {
            system.out.printLn("testestest");
            taskList.set(index, task);
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
        }
    }

    public List<String> listTasks() {
        return taskList;
    }

    public void emptyList() {
        taskList.clear();
    }
}
