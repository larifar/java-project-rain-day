package com.rainday.service;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Service
public class KeyService {
    String getKey(){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
            return properties.getProperty("API_KEY");

        } catch (IOException e) {
           return null;
        }
    }
}
