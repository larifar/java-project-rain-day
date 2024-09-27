package com.rainday.controller;

import com.rainday.dto.WeatherDTOResponse;
import com.rainday.service.RainDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class WeatherController {
    @Autowired
    RainDayService service;

    @GetMapping("/weather/{location}")
    public WeatherDTOResponse getWeather(@PathVariable String location) throws UnsupportedEncodingException {
        return service.getWeather(location);
    }
}
