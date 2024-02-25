package com.example.geektrust;

import com.example.geektrust.entity.Position;
import com.example.geektrust.entity.Ride;
import com.example.geektrust.repository.*;
import com.example.geektrust.service.DriverService;
import com.example.geektrust.service.RideService;
import com.example.geektrust.service.RiderService;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    //initialise repositories
    private final IDriverRepository driverRepository = new DriveRepository();
    private final IRideRepository rideRepository = new RideRepository();
    private final IRiderRepository riderRepository = new RiderRepository();


    //initialise services
    private final DriverService driverService = new DriverService(driverRepository);
    private final RideService rideService = new RideService(rideRepository, riderRepository, driverRepository);
    private final RiderService riderService = new RiderService(riderRepository);

    public static void main(String[] args) {
        if (args.length == 1){
            List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
            String inputFile = commandLineArgs.get(0).split("=")[1];
//            String inPlaceFilepath = "../sample_input/input1.txt";
            try {
                List<String> file_commands = Files.readAllLines(Paths.get(inputFile));
                // Execute the commands
                new Main().run(file_commands);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
    }

    public void run(List<String>commands) {

        for(int i=0; i<commands.size(); i++){
            String line = commands.get(i);
            List<String> tokens = Arrays.asList(line.split(" "));
            try {
                switch(tokens.get(0)){
                    case "ADD_DRIVER": {
                        ADD_DRIVER(tokens);
                    }
                    break;
                    case "ADD_RIDER": {
                        ADD_RIDER(tokens);
                    }
                    break;
                    case  "MATCH": {
                        MATCH(tokens);
                    }
                    break;
                    case "START_RIDE": {
                        START_RIDE(tokens);
                    }
                    break;
                    case "STOP_RIDE": {
                        STOP_RIDE(tokens);
                    }
                    break;
                    case "BILL":{
                        BILL(tokens);
                    }
                    break;
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        
    }

    private void BILL(List<String> tokens) {
        Ride ride = rideService.bill(tokens.get(1));
        String res = "BILL " + ride.getRideId() + " " + ride.getDriver().getDriverId() + " " + ride.getTotal();
        System.out.println(res);
    }

    private void STOP_RIDE(List<String> tokens) {
        Position position = new Position(Double.parseDouble(tokens.get(1)), Double.parseDouble(tokens.get(2)));
        Ride ride = rideService.stopRide(tokens.get(1), position, Long.parseLong(tokens.get(4)));
        String res = "RIDE_STARTED " + ride.getRideId();
        System.out.println(res);
    }

    private void START_RIDE(List<String> tokens) {
    }

    private void MATCH(List<String> tokens) {
    }

    private void ADD_RIDER(List<String> tokens) {
    }

    private void ADD_DRIVER(List<String> tokens) {
    }
}
