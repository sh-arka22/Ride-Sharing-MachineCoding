package com.example.geektrust.service;

import com.example.geektrust.dto.DriverDto;
import com.example.geektrust.entity.Driver;
import com.example.geektrust.repository.IDriverRepository;

public class DriverService {
    private final IDriverRepository driverRepository;
    public DriverService(IDriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(DriverDto driverDto){
        Driver driver = new Driver(driverDto);
        return driverRepository.save(driver);
    }
}
