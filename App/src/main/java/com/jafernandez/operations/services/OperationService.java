package com.jafernandez.operations.services;

import com.jafernandez.operations.dto.OperationType;

import java.math.BigDecimal;

public interface OperationService {

    public BigDecimal realiseOperation(OperationType operation, BigDecimal firstNumber, BigDecimal secondNumber);

}
