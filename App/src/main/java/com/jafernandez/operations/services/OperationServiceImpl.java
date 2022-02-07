package com.jafernandez.operations.services;

import com.jafernandez.operations.dto.OperationType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperationServiceImpl implements OperationService {

    @Override
    public BigDecimal realiseOperation(OperationType operation, BigDecimal firstNumber, BigDecimal secondNumber) {

        BigDecimal result = null;

        switch (operation) {
            case SUBTRACTION:
                result = firstNumber.subtract(secondNumber);
                break;
            case SUM:
            default:
                result = firstNumber.add(secondNumber);
                break;
        }

        return result;
    }

}
