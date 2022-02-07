package com.jafernandez.operations.controllers;

import com.jafernandez.operations.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OperationControllerImpl implements OperationsApiDelegate {

    @Autowired
    public OperationService operationService;

    @Override
    public ResponseEntity<BigDecimal> realiseOperation(String operation,
                                                       BigDecimal firstNumber,
                                                       BigDecimal secondNumber) {

        BigDecimal result = this.operationService.realiseOperation(operation, firstNumber, secondNumber);
        return ResponseEntity.ok(result);
    }

}
