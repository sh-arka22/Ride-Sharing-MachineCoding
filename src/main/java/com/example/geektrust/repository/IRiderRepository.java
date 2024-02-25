package com.example.geektrust.repository;

import com.example.geektrust.entity.Rider;

import java.util.Optional;

public interface IRiderRepository {
    public Rider save(Rider rider);
    public Optional<Rider> getById(String riderId);
}
