package com.example.geektrust.entity;

import com.example.geektrust.dto.RideDto;

public class Ride {
    private final String rideId;
    private final Rider rider;
    private final Driver driver;
    private final Position startPosition;
    private Position endPosition;
    private Long duration;
    private boolean status;
    private Double total;

    public Ride(RideDto rideDto){
        this.rideId = rideDto.getRideId();
        this.rider = rideDto.getRider();
        this.driver = rideDto.getDiver();
        this.startPosition = rideDto.getRider().getPosition();
        this.status = true;
    }

    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Position endPosition) {
        this.endPosition = endPosition;
    }

    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public void setDuration(Long duration){
        this.duration = duration;
    }
    public Long getDuration(){
        return this.duration;
    }
    public Double getTotal(){
        return this.total;
    }
    public void setTotal(Double total){
        this.total = total;
    }
}
