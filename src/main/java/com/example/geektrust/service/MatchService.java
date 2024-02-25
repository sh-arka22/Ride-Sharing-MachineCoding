package com.example.geektrust.service;

import com.example.geektrust.entity.Driver;
import com.example.geektrust.entity.Position;
import com.example.geektrust.entity.Rider;
import com.example.geektrust.repository.IDriverRepository;
import com.example.geektrust.repository.IRiderRepository;

import java.util.*;

public class MatchService {
    private final IRiderRepository riderRepository;
    private final IDriverRepository driverRepository;
    public MatchService(IDriverRepository driverRepository, IRiderRepository riderRepository){
        this.riderRepository = riderRepository;
        this.driverRepository = driverRepository;
    }

    public List<Driver> match(String riderId){
        Rider rider = riderRepository.getById(riderId).orElseThrow(()->new RuntimeException("Rider with id: " + riderId+ " was not fond"));
        List<Driver> drivers =  matchedDrivers(rider);
        rider.setMatchedDrivers(drivers);
        return drivers;
    }







    //utilities
    private Double distance(Position posA, Position posB){
        Double disX = posA.getX_axis()-posB.getX_axis();
        Double disY = posA.getY_axis()-posB.getY_axis();
        return disX*disX + disY*disY;
    }
    private List<Driver> matchedDrivers(Rider rider){
        List<Driver> drivers = driverRepository.getAll();
        if(drivers.isEmpty()) throw new RuntimeException("NO_DRIVERS_AVAILABLE");
        Comparator<Driver> cmp = (d1, d2)->{
            Position r1 = rider.getPosition();
            Position p1 = d1.getPosition();
            Position p2 = d2.getPosition();
            if(distance(r1, p1) < distance(r1, p2))
                return -1;
            else if(distance(r1, p1) == distance(r1, p2))
                return d1.getDriverId().compareTo(d2.getDriverId());
            return 1;
        };
        Collections.sort(drivers, cmp);

        //filtering with 5 closest drivers and drivers with in 5km in distance
        while(drivers.size() != 0 && drivers.size() > 5){
            Driver farthestDriver = drivers.get(drivers.size()-1);
            if(distance(rider.getPosition(), farthestDriver.getPosition()) > 5){
                drivers.removeLast();
            }
        }
        if(drivers.isEmpty()) throw new RuntimeException("NO_DRIVERS_AVAILABLE");
        return drivers;
    }

}
