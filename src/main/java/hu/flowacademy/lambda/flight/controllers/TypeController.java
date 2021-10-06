package hu.flowacademy.lambda.flight.controllers;


import hu.flowacademy.lambda.flight.models.TypeModel;
import hu.flowacademy.lambda.flight.services.TypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }


    @PostMapping("/")
    public void addType(TypeModel typeModel){
        typeService.addType(typeModel);
    }


}
