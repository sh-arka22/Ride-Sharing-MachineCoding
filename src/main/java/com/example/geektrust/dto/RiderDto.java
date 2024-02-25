package com.example.geektrust.dto;

import com.example.geektrust.entity.Position;

public class RiderDto {
    public final String riderId;
    public final Position position;

    public  RiderDto(String riderId, Double x_axis, Double y_axis){
        this.riderId = riderId;
        this.position = new Position(x_axis, y_axis);
    }
    public RiderDto(String riderId,Position position){
        this.riderId = riderId;
        this.position = position;
    }
}
