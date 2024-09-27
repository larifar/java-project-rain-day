package com.rainday;

import com.rainday.service.WeatherAPICurrentWeatherService;
import com.rainday.service.WeatherAPIGeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private WeatherAPIGeoLocationService geoLocationService;

    @Autowired
    private WeatherAPICurrentWeatherService weatherService;


    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("oii");
        var r = geoLocationService.getLocation("São%20Paulo");
        System.out.println(r);
        System.out.println(weatherService.getCurrentWeather(r));

    }
}
