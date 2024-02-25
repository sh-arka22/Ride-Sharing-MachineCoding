package com.example.geektrust.service;

import com.example.geektrust.dto.RideDto;
import com.example.geektrust.entity.Driver;
import com.example.geektrust.entity.Position;
import com.example.geektrust.entity.Ride;
import com.example.geektrust.entity.Rider;
import com.example.geektrust.repository.IDriverRepository;
import com.example.geektrust.repository.IRideRepository;
import com.example.geektrust.repository.IRiderRepository;

import java.util.List;
import java.util.Optional;


public class RideService {
    private final IRideRepository rideRepository;
    private final IRiderRepository riderRepository;
    private final IDriverRepository driverRepository;

    public RideService(IRideRepository rideRepository, IRiderRepository riderRepository, IDriverRepository driverRepository){
        this.rideRepository = rideRepository;
        this.riderRepository = riderRepository;
        this.driverRepository = driverRepository;
    }


    //start ride
    public Ride startRide(String rideID, int n, String riderID){
        Optional<Ride> ride = rideRepository.getById(rideID);
        Ride savedRide = null;
        if(ride.isPresent()){
            throw new RuntimeException("INVALID_RIDE");
        }
        Rider rider = riderRepository.getById(riderID).orElseThrow(()-> new RuntimeException(riderID + " does not exists"));

        List<Driver> drivers = rider.getMatchedDrivers();

        if(n > drivers.size())
            throw new RuntimeException("INVALID_RIDE");

        Driver driver = drivers.get(n-1);
        if(driver.getStatus() == true)
            throw new RuntimeException("INVALID_RIDE");


        //setting the status as occupied
        driver.setStatus(true);

        RideDto rideDto = new RideDto(rideID, rider, driver);

        savedRide = rideRepository.save(new Ride(rideDto));

        //setting the status as active
        savedRide.setStatus(true);

        return savedRide;
    }



    //stop ride
    public Ride stopRide(String rideId, Position endPosition, Long duration){
        Ride ride = rideRepository.getById(rideId).orElseThrow(()->new RuntimeException("INVALID_RIDE"));
        if(ride.getStatus() == false)
            throw new RuntimeException("INVALID_RIDE");

        ride.setEndPosition(endPosition);
        ride.setDuration(duration);

        ride.setStatus(false);
        ride.getDriver().setStatus(false);
        return ride;
    }

    public Ride bill(String rideId){
        Ride ride = rideRepository.getById(rideId).orElseThrow(()->new RuntimeException("INVALID_RIDE"));
        Position start = ride.getStartPosition();
        Position end = ride.getEndPosition();
        Double distanceCovered = distance(start, end);
        Long duration = ride.getDuration();

        double total = 0.0;

        total += 50;

        total += (6.5*distanceCovered);

        total += (2*duration);

        total = total + (total*20.0/100.0);

        ride.setTotal((double) (Math.round(total * 100) /100));

        return ride;
    }
    private Double distance(Position posA, Position posB){
        Double x1 = posA.getX_axis();
        Double y1 = posA.getY_axis();

        Double x2 = posB.getX_axis();
        Double y2 = posB.getY_axis();

        return calculateDistance(x1, y1, x2, y2);
    }
    private Double calculateDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return Math.round(distance * 100.0) / 100.0;
    }
}
