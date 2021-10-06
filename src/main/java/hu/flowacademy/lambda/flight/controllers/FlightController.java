package hu.flowacademy.lambda.flight.controllers;

import hu.flowacademy.lambda.flight.models.Flight;
import hu.flowacademy.lambda.flight.models.FlightModel;
import hu.flowacademy.lambda.flight.services.FlightModelService;
import hu.flowacademy.lambda.flight.services.FlightService;
import hu.flowacademy.lambda.flight.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    private FlightModelService flightModelService;
    private TypeService typeService;
    private FlightService flightService;


    public FlightController(FlightModelService flightModelService, TypeService typeService) {
        this.flightModelService = flightModelService;
        this.typeService = typeService;
    }

    @PostMapping("/")
    public void addFlight(@RequestBody FlightModel flightModel){
        flightModelService.addFlightToFleet(flightModel);
    //  var type = typeService.flightModelToType(flightModel);
      //    typeService.addType(type);
      // flightService.addFlight(flightModel);

    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable Long id){
        return typeService.entityToDTO(flightModelService.findFlight(id));
    }

   @GetMapping("/")
    public List<Flight> allFlights(){

       return flightModelService.
                findAllFlights()
                .stream()
                .map(n->typeService.entityToDTO(n))
                .collect(Collectors.toList());
    }



}
