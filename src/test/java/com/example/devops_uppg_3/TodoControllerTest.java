package com.example.devops_uppg_3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddTask_ShouldAddTask() throws Exception {

        mockMvc.perform(get("/api/emptyList"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/add?task=testAddTask"))
                .andExpect(status().isOk());

//        mockMvc.perform(get("/api/add").param("task", "Test Task"))
//                .andExpect(status().isOk());

        mockMvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of("testAddTask"))));

    }

    @Test
    void testModifyTask_ShouldModifyTask() throws Exception {

        mockMvc.perform(get("/api/emptyList"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/add?task=test"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/modify?task=testModified&index=0"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of("testModified"))));
    }

    @Test
    void testDeleteTask_ShouldDeleteTask() throws Exception {

        mockMvc.perform(get("/api/emptyList"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/add?task=testDelete"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/delete?index=0"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of())));
    }

    @Test
    void testListTasks_ShouldListAllTasks() throws Exception {

        mockMvc.perform(get("/api/emptyList"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/add?task=testList1"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/add?task=testList2"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/add?task=testList3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of("testList1", "testList2", "testList3"))));

    }

    @Test
    void emptyList() throws Exception {

        mockMvc.perform(get("/api/emptyList"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/add?task=testEmpty1"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/add?task=testEmpty2"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/add?task=testEmpty3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/emptyList"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of())));

    }
}
