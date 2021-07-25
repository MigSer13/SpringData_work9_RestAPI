package ru.geekbrains.market.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> catchResourceNotFoundExeption(ResourceNotFoundExeption e){
        return new ResponseEntity<>(new MarkerError(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
