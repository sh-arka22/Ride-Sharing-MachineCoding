package com.example.geektrust.repository;

import com.example.geektrust.dto.DriverDto;
import com.example.geektrust.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface IDriverRepository {
    Driver save(Driver driver);
    List<Driver> getAll();
    Optional<Driver> getById(String driverId);
}
