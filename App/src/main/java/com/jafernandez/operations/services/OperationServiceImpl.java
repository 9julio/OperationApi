package com.jafernandez.operations.services;

import com.jafernandez.operations.dto.OperationType;
import com.jafernandez.operations.exceptions.NotImplementedOperationTypeException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperationServiceImpl implements OperationService {

    /**
     *
     * This method validate that the operations has logic. If has not logic, return a exception.
     *
     * @param operationType
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    @Override
    public BigDecimal performOperation(OperationType operationType, BigDecimal firstNumber, BigDecimal secondNumber) {

        if (operationType == null
                || firstNumber == null
                || secondNumber == null) {
            throw new NotImplementedOperationTypeException("The params operation, firstNumber and secondNumber are mandatories.");
        }

        BigDecimal result = null;

        switch (operationType) {
            case SUBTRACTION:
                result = firstNumber.subtract(secondNumber);
                break;
            case SUM:
                result = firstNumber.add(secondNumber);
                break;
            default:
                throw new NotImplementedOperationTypeException(String.format("The operation %s is not implemented.", operationType.name()));
        }

        return result;
    }

}
