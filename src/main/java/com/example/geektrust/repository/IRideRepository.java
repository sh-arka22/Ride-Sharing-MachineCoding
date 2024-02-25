package com.example.geektrust.repository;

import com.example.geektrust.entity.Ride;

import java.util.Optional;

public interface IRideRepository {
    Ride save(Ride ride);
    Optional<Ride> getById(String rideID);
}
