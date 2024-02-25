package com.example.geektrust.entity;

import com.example.geektrust.dto.DriverDto;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class Driver {
    private final String driverId;
    private final Position position;
    private boolean status;
    private List<Ride> rides;

    public Driver(DriverDto driverDto){
        this.position = driverDto.position;
        driverId = null;
        status = false;
    }

    public String getDriverId() {
        return driverId;
    }


    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
    public void addRide(Ride ride){
        this.rides.add(ride);
    }

    public Position getPosition() {
        return position;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Driver{");
        sb.append("driverId=").append(driverId);
        sb.append(", position=").append(position);
        sb.append(", rides=").append(rides);
        sb.append('}');
        return sb.toString();
    }
}
