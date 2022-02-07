package com.jafernandez.operations.services;

import com.jafernandez.operations.dto.OperationType;
import com.jafernandez.operations.exceptions.NotImplementedOperationTypeException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationServiceTests {

  @InjectMocks
  private OperationService operationService = new OperationServiceImpl();

  @Test
  public void tryToSum() throws NotImplementedOperationTypeException {

    OperationType operation = OperationType.SUM;
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.realiseOperation(operation, firstNumber, secondNumber);
    assertEquals(BigDecimal.valueOf(11L), result);
  }

  @Test
  public void tryToSubtraction() throws NotImplementedOperationTypeException {

    OperationType operation = OperationType.SUBTRACTION;
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.realiseOperation(operation, firstNumber, secondNumber);
    assertEquals(BigDecimal.valueOf(9L), result);
  }

}
