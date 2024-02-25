package com.example.geektrust.service;

import com.example.geektrust.dto.RiderDto;
import com.example.geektrust.entity.Rider;
import com.example.geektrust.repository.IRiderRepository;

public class RiderService {
    private final IRiderRepository riderRepository;
    public RiderService(IRiderRepository riderRepository){
        this.riderRepository = riderRepository;
    }
    public Rider addRider(RiderDto riderDto){
        Rider rider = new Rider(riderDto);
        return riderRepository.save(rider);
    }
}
