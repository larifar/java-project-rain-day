package com.rainday.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rainday.dto.CoordenatesDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import static com.rainday.service.HTTPRequestGet.getConnection;

@Service
public class WeatherAPIGeoLocationService {
    private final String URL_BASE = "http://api.openweathermap.org/geo/1.0/direct?q=";
    private final String KEY = new KeyService().getKey();
    private final String COMPLEMENT = "&limit=1&appid=";


    public CoordenatesDTO getLocation(String local) {
        try {
            URL url = new URL(URL_BASE + local + COMPLEMENT + KEY);
            var resposta = getConnection(url);

            return transformBufferToDTO(resposta);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private CoordenatesDTO transformBufferToDTO(StringBuffer buffer){
        Gson gson = new Gson();
        Type locationType = new TypeToken<List<CoordenatesDTO>>() {}.getType();
        List<CoordenatesDTO> coordenatesList = gson.fromJson(buffer.toString(), locationType);

        if (coordenatesList != null && !coordenatesList.isEmpty()) {
            return coordenatesList.get(0);
        } else {
            return null;
        }
    }
}
