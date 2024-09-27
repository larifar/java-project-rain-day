package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record Weather(
        @SerializedName("id") int id,
        @SerializedName("main") String main,
        @SerializedName("description") String description,
        @SerializedName("icon") String icon
){}
