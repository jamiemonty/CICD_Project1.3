package ie.atu.weightapplication;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "weight_class")
public class WeightClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weightId;
    private String weightRange;

    public WeightClass() {}

    public WeightClass(Long id, String weightRange) {
        this.weightId = id;
        this.weightRange = weightRange;
    }

    public Long getId() {
        return weightId;
    }

    public void setId(Long id) {
        this.weightId = id;
    }

    public String getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(String weightRange) {
        this.weightRange = weightRange;
    }
}
