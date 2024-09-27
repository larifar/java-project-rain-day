package com.rainday.controller;

import com.rainday.dto.WeatherDTOResponse;
import com.rainday.model.AppModel;
import com.rainday.service.RainDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class WeatherController {
    @Autowired
    RainDayService service;

    @GetMapping("/weather/{location}")
    public ResponseEntity<AppModel> getWeather(@PathVariable String location) throws UnsupportedEncodingException {
        WeatherDTOResponse dto = service.getWeather(location);
        return new ResponseEntity<>(new AppModel(location, dto), HttpStatus.OK);
    }
}
