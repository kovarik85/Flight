package hu.flowacademy.lambda.flight.repositories;

import hu.flowacademy.lambda.flight.models.TypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository <TypeModel, Long> {



}
