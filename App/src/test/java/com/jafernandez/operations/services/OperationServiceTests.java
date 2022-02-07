package com.jafernandez.operations.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OperationServiceTests {

  @InjectMocks
  private OperationService operationService = new OperationServiceImpl();

  @Test
  public void tryToSum() {

    String operation = "SUM";
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.realiseOperation(operation, firstNumber, secondNumber);
    assertEquals(BigDecimal.valueOf(11L), result);
  }

  @Test
  public void tryToSubtraction() {

    String operation = "SUBTRACTION";
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.realiseOperation(operation, firstNumber, secondNumber);
    assertEquals(BigDecimal.valueOf(9L), result);
  }

  @Test
  public void tryUnsupportedOperation() {

    String operation = "MY-OPERATION";
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.realiseOperation(operation, firstNumber, secondNumber);
    assertNull(result);
  }

}
