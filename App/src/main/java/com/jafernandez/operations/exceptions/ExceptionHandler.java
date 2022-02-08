package com.jafernandez.operations.exceptions;

import com.jafernandez.operations.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.math.BigDecimal;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(InvalidOperationTypeException.class)
  public ResponseEntity<ErrorResponseDto> invalidOperationTypeException(InvalidOperationTypeException e) {

    ErrorResponseDto errorResponseDto = new ErrorResponseDto();

    errorResponseDto.setCode(BigDecimal.valueOf(HttpStatus.BAD_REQUEST.value()));
    errorResponseDto.setDescription(e.getMessage());

    return ResponseEntity
            .badRequest()
            .body(errorResponseDto);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(NotImplementedOperationTypeException.class)
  public ResponseEntity<ErrorResponseDto> notImplementedOperationTypeException(NotImplementedOperationTypeException e) {

    ErrorResponseDto errorResponseDto = new ErrorResponseDto();

    errorResponseDto.setCode(BigDecimal.valueOf(HttpStatus.BAD_REQUEST.value()));
    errorResponseDto.setDescription(e.getMessage());

    return ResponseEntity
            .badRequest()
            .body(errorResponseDto);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponseDto> illegalArgumentException(Exception e) {

    ErrorResponseDto errorResponseDto = new ErrorResponseDto();

    errorResponseDto.setCode(BigDecimal.valueOf(HttpStatus.BAD_REQUEST.value()));
    errorResponseDto.setDescription("This is a bad argument.");

    return ResponseEntity
            .badRequest()
            .body(errorResponseDto);
  }

}
