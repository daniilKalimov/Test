package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAddTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/add?left=1&right=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    void getAddBadRequestSymbolInParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/add?left=d&right=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getAddBadRequestWithoutParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/add")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getSubtractTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/subtract?from=4&subtract=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    void getSubtractBadRequestSymbolInParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/subtract?from=a&subtract=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getSubtractBadRequestWithoutParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/subtract")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getMultiplyTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/multiply?left=4&right=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.result").value(8));
    }

    @Test
    void getMultiplyBadRequestSymbolInParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/multiply?left=a&right=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getMultiplyBadRequestWithoutParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/multiply")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getDivideTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/divide?dividend=4&divisor=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    void getDivideBadRequestSymbolInParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/divide?dividend=a&divisor=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getDivideBadRequestWithoutParamsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/divide")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getDivideExceptionTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/divide?dividend=4&divisor=0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.error").value("java.lang.ArithmeticException: Division by zero"))
                .andExpect(jsonPath("$.result").isEmpty());
    }
















}
