package hu.flowacademy.lambda.flight.services;

import hu.flowacademy.lambda.flight.models.Flight;
import hu.flowacademy.lambda.flight.models.FlightModel;
import hu.flowacademy.lambda.flight.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private TypeService typeService;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> allFlights (){
       return flightRepository.findAll();
    }

    public void addFlight(FlightModel flightModel){

        flightRepository.save(typeService.entityToDTO(flightModel));
    }

}
