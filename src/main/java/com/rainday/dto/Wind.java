package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record Wind(
        @SerializedName("speed") double speed,
        @SerializedName("deg") int deg
){}
