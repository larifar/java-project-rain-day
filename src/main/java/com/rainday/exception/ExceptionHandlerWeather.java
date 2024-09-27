package com.rainday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerWeather {

    @ExceptionHandler(WeatherAPIException.class)
    public ResponseEntity<String> handleAPIException(WeatherAPIException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Ocorreu um erro no sistema. Tente novamente mais tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
