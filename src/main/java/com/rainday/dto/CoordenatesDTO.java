package com.rainday.dto;

import com.google.gson.annotations.SerializedName;

public record CoordenatesDTO(
        @SerializedName("name") String name,
        @SerializedName("lat") Double  latitude,
        @SerializedName("lon") Double longitude,
        @SerializedName("country") String country,
        @SerializedName("state") String state
) {
}
