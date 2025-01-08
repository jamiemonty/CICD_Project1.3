package ie.atu.weightapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeightClassRepository extends JpaRepository<WeightClass, Long> {
    @Query("SELECT w.weightRange FROM WeightClass w")
    List<String> findAllWeightRanges();
}
