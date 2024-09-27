package com.rainday.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequestGet {
    public static StringBuffer getConnection(URL url) throws IOException {
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200)
            throw new RuntimeException("HTTP error code : " + connection.getResponseCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer resposta = new StringBuffer();

        String linha;
        while ((linha = reader.readLine()) != null) {
            resposta.append(linha);
        }
        reader.close();
        return resposta;
    }
}
