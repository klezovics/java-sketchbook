package com.klezovich.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RegisterRestController.class)
public class RegisterRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterUseCase registerUseCase;

    @Test
    public void whenValidInput_thenReturns200() throws Exception {
        UserResource user = new UserResource("AK", "ak@gmail.com");

        mockMvc.perform(
            post("/forums/42/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user))
                .param("sendWelcomeEmail", "false"))
            .andExpect(status().isOk());
    }
}