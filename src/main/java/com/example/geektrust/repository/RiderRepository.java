package com.example.geektrust.repository;

import com.example.geektrust.entity.Rider;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RiderRepository implements IRiderRepository{
    Map<String, Rider> riderMap;
    public RiderRepository(){
        riderMap = new HashMap<>();
    }
    @Override
    public Rider save(Rider rider) {
        riderMap.put(rider.getRiderId(), rider);
        return rider;
    }

    @Override
    public Optional<Rider> getById(String riderId) {
        return Optional.ofNullable(riderMap.get(riderId));
    }
}
