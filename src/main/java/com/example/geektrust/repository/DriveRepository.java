package com.example.geektrust.repository;

import com.example.geektrust.entity.Driver;

import java.util.*;

public class DriveRepository implements IDriverRepository{
    Map<String, Driver> driverMap;
    public DriveRepository(){
        driverMap = new HashMap<>();
    }
    @Override
    public Driver save(Driver driver) {
        driverMap.put(driver.getDriverId(), driver);
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        return new ArrayList<>(driverMap.values());
    }

    @Override
    public Optional<Driver> getById(String driverId) {
        return Optional.ofNullable(driverMap.get(driverId));
    }
}
