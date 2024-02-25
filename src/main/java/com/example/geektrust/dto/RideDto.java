package com.example.geektrust.dto;

import com.example.geektrust.entity.Driver;
import com.example.geektrust.entity.Ride;
import com.example.geektrust.entity.Rider;

public class RideDto {
    private final String rideId;
    private final Rider rider;
    private final Driver diver;

    public RideDto(String rideId, Rider rider, Driver driver){
        this.rideId = rideId;
        this.rider = rider;
        this.diver = driver;
    }

    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDiver() {
        return diver;
    }
}
