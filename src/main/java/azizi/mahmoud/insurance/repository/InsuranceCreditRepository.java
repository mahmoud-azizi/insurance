package azizi.mahmoud.insurance.repository;

import azizi.mahmoud.insurance.model.entity.InsuranceCreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCreditRepository extends JpaRepository<InsuranceCreditEntity, Long> {

    @Query("SELECT a FROM InsuranceCreditEntity a where a.identityInformationEntity.nationalCode = ?1")
    InsuranceCreditEntity findByNationalCode(String nationalCode);
}
