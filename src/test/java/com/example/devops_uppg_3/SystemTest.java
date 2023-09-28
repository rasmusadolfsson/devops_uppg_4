package com.example.devops_uppg_3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class SystemTest {

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }



    @Test
    void getListTest_ShouldReturn200AndList() {
        given().
                when().
                get("/api/emptyList").
                then().
                statusCode(200);
        given().
                param("task", "test").
                when().
                post("/api/add").
                then().
                statusCode(200)
                .body(equalTo("Task added!"));
        given().
                when().
                get("/api/list").
                then().
                statusCode(200)
                .body(equalTo("[\"test\"]"));
    }

    @Test
    void addTaskTest_ShouldReturn200AndConfirmation() {
        given().
                when().
                get("/api/emptyList").
                then().
                statusCode(200);
        given().
                param("task", "test").
                when().
                post("/api/add").
                then().
                statusCode(200)
                .body(equalTo("Task added!"));
    }

    @Test
    void modifyTaskTest_ShouldReturn200AndConfirmation() {
        given().
                when().
                get("/api/emptyList").
                then().
                statusCode(200);
        given().
                param("task", "test").
                when().
                post("/api/add").
                then().
                statusCode(200)
                .body(equalTo("Task added!"));
        given().
                param("task", "test2").
                param("index", 0).
                when().
                post("/api/modify").
                then().
                statusCode(200);
    }

    @Test
    void deleteTaskTest_ShouldReturn200AndConfirmation() {
        given().
                when().
                get("/api/emptyList").
                then().
                statusCode(200);
        given().
                param("task", "test").
                when().
                post("/api/add").
                then().
                statusCode(200)
                .body(equalTo("Task added!"));
        given().
                param("index", 0).
                when().
                post("/api/delete").
                then().
                statusCode(200);
    }
}
