package com.jafernandez.operations.services;

import com.jafernandez.operations.dto.OperationType;

import java.math.BigDecimal;

public interface OperationService {

    /**
     *
     * @param operation
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public BigDecimal performOperation(OperationType operation, BigDecimal firstNumber, BigDecimal secondNumber);

}
