package com.jafernandez.operations.controllers;

import com.jafernandez.operations.dto.OperationType;
import com.jafernandez.operations.exceptions.InvalidOperationTypeException;
import com.jafernandez.operations.services.OperationService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OperationControllerImpl implements OperationsApiDelegate {

    @Autowired
    public OperationService operationService;

    private io.corp.calculator.TracerImpl tracerApi = new TracerImpl();

    /**
     * This method receive the params, validate and call the service.
     *
     * @param operation Operation that you can realise. (required)
     * @param firstNumber First number that you can operate. (required)
     * @param secondNumber Second number that you can operate. (required)
     * @return
     */
    @Override
    public ResponseEntity<BigDecimal> performOperation(String operation,
                                                       BigDecimal firstNumber,
                                                       BigDecimal secondNumber) {

        ResponseEntity responseEntity;

        OperationType operationType = OperationType.valueOf(operation);
        if (!OperationType.allTypes.contains(operationType)) {
            tracerApi.trace(String.format("The operation type %s is invalid.", operation));
            throw new InvalidOperationTypeException(String.format("The operation type %s is invalid.", operation));
        } else {
            tracerApi.trace(String.format("The operation has the next params operation: %s firstNumber: %s and secondNumber = %s",
                    operationType.name(), firstNumber, secondNumber));

            BigDecimal result = this.operationService.performOperation(operationType, firstNumber, secondNumber);
            tracerApi.trace(String.format("The result of the operation %s is %s", operationType.name(), result));

            responseEntity = ResponseEntity.ok(result);
        }

        return responseEntity;
    }

}
