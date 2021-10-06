package hu.flowacademy.lambda.flight.services;

import hu.flowacademy.lambda.flight.models.Flight;
import hu.flowacademy.lambda.flight.models.FlightModel;
import hu.flowacademy.lambda.flight.models.TypeModel;
import hu.flowacademy.lambda.flight.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TypeService {

    @Autowired
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void addType(TypeModel typeModel){
        typeRepository.save(typeModel);
    }

    public Flight entityToDTO(FlightModel flightModel){
       var flight = new Flight();
       flight.setTypeId(flightModel.getType().getId());
       flight.setCreated(flightModel.getCreated());
       flight.setId(flightModel.getId());
       return flight;
    }

    public FlightModel DTOToEntity(Flight flight){
        var flightModel = new FlightModel();
        flightModel.setType(typeRepository.findById(flight.getTypeId()).orElse(null));
        flightModel.setCreated(flight.getCreated());
        flightModel.setId(flight.getId());
        return flightModel;
    }

    public TypeModel flightModelToType(FlightModel flightModel){
        var type = new TypeModel();
        type.setName(flightModel.getType().getName());
        return type;
    }

}
