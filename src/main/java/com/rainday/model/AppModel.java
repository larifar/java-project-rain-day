package com.rainday.model;

import com.rainday.dto.WeatherDTOResponse;

public class AppModel {
    private String city;
    private String description;
    private double tempNow;
    private double tempMin;
    private double tempMax;
    private int humidity;

    private Boolean isRaining;

    private String taskDay;
    private String walkDay;

    public AppModel(String location, WeatherDTOResponse response){
        this.city = location;
        this.description = translateDesc(response.weather().get(0).id());
        this.tempNow = response.main().temp();
        this.tempMax = response.main().temp_max();
        this.tempMin = response.main().temp_min();
        this.humidity = response.main().humidity();
        this.isRaining = description.contains("rain");
        this.taskDay = task(tempMin, tempMax, humidity, isRaining);
        this.walkDay = walk(tempNow, isRaining, humidity);
    }

    private String walk(double tempNow, Boolean isRaining, int humidity) {
        if (isRaining) {
            return "Não esqueça o guarda-chuva!!";
        }

        if (tempNow > 32 && humidity < 20) {
            return "Melhor fazer exercício em casa";
        } else if (tempNow > 28 && humidity > 30) {
            return "Uma corrida leve...";
        } else if (tempNow > 19 && humidity > 30 && humidity < 80) {
            return "Ótimo dia para correr :D";
        } else {
            return "Ótimo dia para uma caminhada";
        }
    }

    private String task(double tempMin, double tempMax, int humidity, Boolean isRaining) {
        if (tempMin > 20 && tempMax > 25 && humidity < 50) {
            return "Dia perfeito para lavar roupas!!! :D";
        } else if (isRaining || tempMax < 19 || humidity > 90) {
            return "Não lave roupas hoje :(";
        } else if (humidity > 60) {
            return "Talvez lave mas só secam daqui 2 dias...";
        } else {
            return "Pode lavar roupas ;)";
        }
    }

    private String translateDesc(int id){
        if (id < 250){
            return "Tempestade";
        } else if (id < 350){
            return "Garoa";
        } else if (id < 550){
            return "Chuva";
        } else if (id == 800){
            return "Céu limpo";
        } else if (id >800){
            return "Céu nublado";
        }
        return "Neve";
    }


    public AppModel() {
    }

    public Boolean getRaining() {
        return isRaining;
    }

    public void setRaining(Boolean raining) {
        isRaining = raining;
    }

    public String getWalkDay() {
        return walkDay;
    }

    public void setWalkDay(String walkDay) {
        this.walkDay = walkDay;
    }

    public String getTaskDay() {
        return taskDay;
    }

    public void setTaskDay(String taskDay) {
        this.taskDay = taskDay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTempNow() {
        return tempNow;
    }

    public void setTempNow(double tempNow) {
        this.tempNow = tempNow;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
