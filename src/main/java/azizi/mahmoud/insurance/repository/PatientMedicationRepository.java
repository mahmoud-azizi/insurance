package azizi.mahmoud.insurance.repository;

import azizi.mahmoud.insurance.model.entity.PatientMedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMedicationRepository extends JpaRepository<PatientMedicationEntity, Long> {
}
