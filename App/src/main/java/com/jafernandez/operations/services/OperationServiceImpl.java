package com.jafernandez.operations.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperationServiceImpl implements OperationService {

    @Override
    public BigDecimal realiseOperation(String operation, BigDecimal firstNumber, BigDecimal secondNumber) {
        return BigDecimal.valueOf(2.87);
    }

}
