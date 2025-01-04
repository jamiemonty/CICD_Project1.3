package ie.atu.weightapplication;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weight-class")
public class WeightClassController {

    private final WeightClassRepository weightClassRepository;
    public WeightClassController(WeightClassRepository weightClassRepository) {
        this.weightClassRepository = weightClassRepository;
    }

    @GetMapping
    public List<WeightClass> getAllWeightClasses() {
        return weightClassRepository.findAll();
    }
}
