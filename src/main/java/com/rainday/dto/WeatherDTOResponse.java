package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record WeatherDTOResponse(
        @SerializedName("weather") List<Weather> weather,
        @SerializedName("main") Main main,
        @SerializedName("visibility") int visibility,
        @SerializedName("wind") Wind wind,
        @SerializedName("rain") Rain rain,
        @SerializedName("clouds") Clouds clouds,
        @SerializedName("dt") long dt,
        @SerializedName("sys") Sys sys
) {
}
record Weather(
        @SerializedName("id") int id,
        @SerializedName("main") String main,
        @SerializedName("description") String description,
        @SerializedName("icon") String icon
){}
record Main(
        @SerializedName("temp") double temp,
        @SerializedName("feels_like") double feels_like,
        @SerializedName("temp_min") double temp_min,
        @SerializedName("temp_max") double temp_max,
        @SerializedName("pressure")int pressure,
        @SerializedName("humidity") int humidity
){}

record Wind(
        @SerializedName("speed") double speed,
        @SerializedName("deg") int deg
){}

record Rain(
        @SerializedName("1h") double hour,
        @SerializedName("3h") double tree_hour
){}

record Clouds(
        @SerializedName("all") int all
){}

record Sys(
        @SerializedName("sunrise") long sunrise,
        @SerializedName("sunset") long sunset
){}