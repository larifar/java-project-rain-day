package com.rainday.service;

import com.rainday.dto.WeatherDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class RainDayService {
    @Autowired
    private WeatherAPIGeoLocationService geoLocationService;

    @Autowired
    private WeatherAPICurrentWeatherService weatherService;

    public WeatherDTOResponse getWeather(String location) throws UnsupportedEncodingException {
        var coord = geoLocationService.getLocation(transformLocation(location));
        if (coord == null) {
            throw new RuntimeException("Não foi possível obter as coordenadas para a localização: " + location);
        }
        return weatherService.getCurrentWeather(coord);
    }

    private String transformLocation(String location){
        location = location.replaceAll("(?<!^)([A-Z])", "+$1").trim();
        return URLEncoder.encode(location, StandardCharsets.UTF_8);
    }
}
