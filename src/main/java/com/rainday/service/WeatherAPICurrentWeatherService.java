package com.rainday.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rainday.dto.CoordenatesDTO;
import com.rainday.dto.WeatherDTOResponse;
import com.rainday.exception.WeatherAPIException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;

import static com.rainday.service.HTTPRequestGet.getConnection;

@Service
public class WeatherAPICurrentWeatherService {
    private final String URL_BASE = "https://api.openweathermap.org/data/2.5/weather?";
    private final String KEY_UNITS = "&appid="+ new KeyService().getKey() +"&units=metric";
    private final String LAT = "&lat=";
    private final String LON = "&lon=";

    public WeatherDTOResponse getCurrentWeather(CoordenatesDTO dto) {
        try {
            URL url = new URL(URL_BASE + LAT + dto.latitude() + LON + dto.longitude() + KEY_UNITS);
            var resposta = getConnection(url);
            return transformBufferToDTO(resposta);

        } catch (IOException e) {
            throw new WeatherAPIException("Não foi possível se conectar à API: "+ e.getMessage());
        }
    }

    private WeatherDTOResponse transformBufferToDTO(StringBuffer buffer){
        Gson gson = new Gson();
        Type locationType = new TypeToken<WeatherDTOResponse>() {}.getType();
        return gson.fromJson(buffer.toString(), locationType);
    }
}
