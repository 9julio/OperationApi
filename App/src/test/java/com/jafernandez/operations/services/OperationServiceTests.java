package com.jafernandez.operations.services;

import com.jafernandez.operations.dto.OperationType;
import com.jafernandez.operations.exceptions.NotImplementedOperationTypeException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationServiceTests {

  @InjectMocks
  private OperationService operationService = new OperationServiceImpl();

  @Test
  public void performOperation_happyPath_SumOK() throws NotImplementedOperationTypeException {

    OperationType operation = OperationType.SUM;
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.performOperation(operation, firstNumber, secondNumber);
    assertEquals(BigDecimal.valueOf(11L), result);
  }

  @Test
  public void performOperation_happyPath_SubtractionOK() throws NotImplementedOperationTypeException {

    OperationType operation = OperationType.SUBTRACTION;
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    BigDecimal result = this.operationService.performOperation(operation, firstNumber, secondNumber);
    assertEquals(BigDecimal.valueOf(9L), result);
  }

  @Test
  public void performOperation_badOperation_givenException() throws NotImplementedOperationTypeException {

    OperationType operation = OperationType.MULTIPLY;
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    NotImplementedOperationTypeException exception = assertThrows(
            NotImplementedOperationTypeException.class,
            () -> this.operationService.performOperation(operation, firstNumber, secondNumber));
  }

  @Test
  public void performOperation_nullOperation_givenException() throws NotImplementedOperationTypeException {

    OperationType operation = null;
    BigDecimal firstNumber = BigDecimal.TEN;
    BigDecimal secondNumber = BigDecimal.ONE;

    NotImplementedOperationTypeException exception = assertThrows(
            NotImplementedOperationTypeException.class,
            () -> this.operationService.performOperation(operation, firstNumber, secondNumber));
  }

  @Test
  public void performOperation_nullNumber_givenException() throws NotImplementedOperationTypeException {

    OperationType operation = OperationType.SUM;
    BigDecimal firstNumber = null;
    BigDecimal secondNumber = BigDecimal.ONE;

    NotImplementedOperationTypeException exception = assertThrows(
            NotImplementedOperationTypeException.class,
            () -> this.operationService.performOperation(operation, firstNumber, secondNumber));
  }

}
