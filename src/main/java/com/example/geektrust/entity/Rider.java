package com.example.geektrust.entity;

import com.example.geektrust.dto.RiderDto;

import java.util.ArrayList;
import java.util.List;

public class Rider {
    private final String riderId;
    private final Position position;
    private List<Ride> rides;
    private List<Driver> matchedDrivers;
    public  Rider(RiderDto riderDto){
        this.riderId = null;
        matchedDrivers = new ArrayList<>();
        this.position = riderDto.position;
    }

    public String getRiderId() {
        return riderId;
    }

    public Double getX_axis() {
        return position.getX_axis();
    }

    public Double getY_axis() {
        return position.getY_axis();
    }

    public Position getPosition(){
        return this.position;
    }
    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
    public void setMatchedDrivers(List<Driver> drivers){
        this.matchedDrivers = drivers;
    }
    public List<Driver> getMatchedDrivers(){
        return this.matchedDrivers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rider{");
        sb.append("riderId=").append(riderId);
        sb.append(", position=").append(position);
        sb.append(", rides=").append(rides);
        sb.append('}');
        return sb.toString();
    }
}
