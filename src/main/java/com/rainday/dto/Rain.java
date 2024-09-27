package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record Rain(
        @SerializedName("1h") double hour,
        @SerializedName("3h") double tree_hour
){}
