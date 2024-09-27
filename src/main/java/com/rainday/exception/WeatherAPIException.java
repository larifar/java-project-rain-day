package com.rainday.exception;

public class WeatherAPIException extends RuntimeException{
    public WeatherAPIException(String message){
        super(message);
    }

    public WeatherAPIException(String message, Throwable cause){
        super(message, cause);
    }
}
