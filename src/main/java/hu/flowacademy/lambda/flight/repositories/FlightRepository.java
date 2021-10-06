package hu.flowacademy.lambda.flight.repositories;

import hu.flowacademy.lambda.flight.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Long> {


    List<Flight> findAll();
}
