package com.example.geektrust.repository;

import com.example.geektrust.entity.Ride;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RideRepository implements IRideRepository{
    Map<String, Ride> rideMap;
    public RideRepository(){
        rideMap = new HashMap<>();
    }

    @Override
    public Ride save(Ride ride) {
        rideMap.put(ride.getRideId(), ride);
        return ride;
    }

    @Override
    public Optional<Ride> getById(String rideID) {
        return Optional.ofNullable(rideMap.get(rideID));
    }
}
