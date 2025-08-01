package com.ecommerce.productservicejuly2025.controllerAdvice;

import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "Arithmetic Exception from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST

        );
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "ArrayIndexOutOfBounds Exception from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST

        );
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "ProductNotFoundException  Exception from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST

        );
        return responseEntity;
    }

}
