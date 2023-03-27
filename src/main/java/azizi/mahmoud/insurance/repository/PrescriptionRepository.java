package azizi.mahmoud.insurance.repository;

import azizi.mahmoud.insurance.model.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {
}
