package com.example.geektrust.dto;

import com.example.geektrust.entity.Position;

public class DriverDto {
    public final String diverId;
    public Position position;
    public  DriverDto(String driverId, Double x_axis, Double y_axis){
        this.diverId = driverId;
        this.position = new Position(x_axis, y_axis);
    }
    public DriverDto(String driverId, Position position){
        this.diverId = driverId;
        this.position = position;
    }
}
