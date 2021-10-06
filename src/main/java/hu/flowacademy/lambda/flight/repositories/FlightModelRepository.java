package hu.flowacademy.lambda.flight.repositories;
import hu.flowacademy.lambda.flight.models.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightModelRepository extends JpaRepository<FlightModel, Long> {

   Optional<FlightModel> findById(Long id);
    List<FlightModel> findAll();

}
