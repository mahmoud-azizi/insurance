package azizi.mahmoud.insurance.repository;

import azizi.mahmoud.insurance.model.entity.IdentityInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityInformationRepository extends JpaRepository<IdentityInformationEntity, Long> {
    IdentityInformationEntity findByNationalCode(String nationalCode);
}
