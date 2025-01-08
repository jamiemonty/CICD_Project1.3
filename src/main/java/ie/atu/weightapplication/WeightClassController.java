package ie.atu.weightapplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/weight-ranges")
    public List<Map<String, Object>> getWeightRanges() {
        return weightClassRepository.findAll().stream()
                .map(weightClass -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("weightId", weightClass.getId());
                    map.put("weightRange", weightClass.getWeightRange());
                    return map;
                })
                .collect(Collectors.toList());
    }
    // Get weight class by ID
    @GetMapping("/{id}")
    public ResponseEntity<WeightClass> getWeightClassById(@PathVariable Long id) {
        Optional<WeightClass> weightClassOptional = weightClassRepository.findById(id);
        if (weightClassOptional.isPresent()) {
            return ResponseEntity.ok(weightClassOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
