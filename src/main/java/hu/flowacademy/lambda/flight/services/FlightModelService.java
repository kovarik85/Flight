package hu.flowacademy.lambda.flight.services;

import hu.flowacademy.lambda.flight.models.FlightModel;
import hu.flowacademy.lambda.flight.repositories.FlightModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FlightModelService {

    @Autowired
    private final FlightModelRepository flightModelRepository;

    public FlightModelService(FlightModelRepository flightModelRepository) {
        this.flightModelRepository = flightModelRepository;
    }

    public FlightModel findFlight(Long id){
       return flightModelRepository.findById(id)
               .orElseThrow(()-> new NoSuchElementException("No such flight in fleet!!!"));
    }
    public void addFlightToFleet(FlightModel flightModel){
        flightModelRepository.save(flightModel);
    }

        public List<FlightModel> findAllFlights(){
          return flightModelRepository.findAll();
        }

}
