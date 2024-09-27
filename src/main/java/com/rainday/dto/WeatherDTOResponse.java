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
) { }