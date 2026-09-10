package com.krishna.product.exception;

import com.krishna.product.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> categoryAlreadyExistsException(CategoryAlreadyExistsException ex, WebRequest webRequest) {

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ex.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false),
                HttpStatus.CONFLICT
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);

    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> categoryNotFoundException(CategoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     An important point to note is that, because we have a base `Exception.class` handler, one might assume that it will be invoked regardless of which exception occurs. However, Spring handles exception resolution differently.
     Spring first looks for an `@ExceptionHandler` that matches the <b>exact exception type</b> that was thrown. If a specific handler is found, Spring executes that handler. If no specific handler is available, Spring falls back to the more general `Exception.class` handler.
     So, the `Exception.class` handler acts as a <b>fallback mechanism</b>, rather than being invoked for every exception.
     */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleGlobalException(Exception ex, WebRequest webRequest) {

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ex.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);

    }
}
