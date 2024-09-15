package com.jeriv.cabbook.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RouteRequestDto {

    @NotNull(message = "Please enter pickup-location")
    private double sourceLat;
    @NotNull(message = "Please enter pickup-location")
    private double sourceLong;
    @NotNull(message = "Please enter drop-location")
    private double desLat;
    @NotNull(message = "Please enter drop-location")
    private double desLong;
    private double nearDis = 1.0d;
}
