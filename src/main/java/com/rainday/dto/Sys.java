package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record Sys(
        @SerializedName("sunrise") long sunrise,
        @SerializedName("sunset") long sunset
){}
