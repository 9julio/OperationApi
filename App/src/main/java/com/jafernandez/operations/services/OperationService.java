package com.jafernandez.operations.services;

import java.math.BigDecimal;

public interface OperationService {

    public BigDecimal realiseOperation(String operation, BigDecimal firstNumber, BigDecimal secondNumber);

}
