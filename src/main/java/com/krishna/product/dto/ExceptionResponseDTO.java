package com.krishna.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDTO {


    private String errorMessage;
    private LocalDateTime dateTime;
    private String apiPath;
    private HttpStatus httpStatus;

}