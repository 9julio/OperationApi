package com.jafernandez.operations.controllers;

import com.jafernandez.operations.OperationsApp;
import io.corp.calculator.TracerAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = OperationsApp.class)
@AutoConfigureMockMvc
public class OperationControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private TracerAPI tracerAPI;

  @Test
  public void realiseOperationOK() throws Exception {

    String operation = "SUM";
    String firstNumber = "1.1";
    String secondNumber = "2.2";

    mvc.perform(get(String.format("/operations/%s?firstNumber=%s&secondNumber=%s", operation, firstNumber, secondNumber))
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(content().string("3.3"));
  }

  @Test
  public void realiseOperationBadRequest() throws Exception {

    String operation = "SUM";
    String firstNumber = "XXX";
    String secondNumber = "2";

    mvc.perform(get(String.format("/operations/%s?firstNumber=%s&secondNumber=%s", operation, firstNumber, secondNumber))
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest());
  }

  @Test
  public void realiseOperationBadOperation() throws Exception {

    String operation = "fake";
    String firstNumber = "1";
    String secondNumber = "2";

    mvc.perform(get(String.format("/operations/%s?firstNumber=%s&secondNumber=%s", operation, firstNumber, secondNumber))
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest());
  }

}
