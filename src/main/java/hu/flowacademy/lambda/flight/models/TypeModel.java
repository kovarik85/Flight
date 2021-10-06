package hu.flowacademy.lambda.flight.models;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<FlightModel> flights = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlightModel> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightModel> flights) {
        this.flights = flights;
    }
}
