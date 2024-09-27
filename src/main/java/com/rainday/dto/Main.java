package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record Main(
        @SerializedName("temp") double temp,
        @SerializedName("feels_like") double feels_like,
        @SerializedName("temp_min") double temp_min,
        @SerializedName("temp_max") double temp_max,
        @SerializedName("pressure")int pressure,
        @SerializedName("humidity") int humidity
){}
