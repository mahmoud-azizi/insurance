package azizi.mahmoud.insurance.repository;

import azizi.mahmoud.insurance.model.entity.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<DrugEntity, Long> {
}
