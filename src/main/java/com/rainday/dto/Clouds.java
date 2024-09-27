package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record Clouds(
        @SerializedName("all") int all
){}
