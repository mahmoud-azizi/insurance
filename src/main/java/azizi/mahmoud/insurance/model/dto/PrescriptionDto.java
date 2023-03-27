package azizi.mahmoud.insurance.model.dto;

import azizi.mahmoud.insurance.model.entity.DrugEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
// نسخه
public class PrescriptionDto {
    private Long doctorId;
    private Long patientId;
    private String note;
    private List<DrugEntity> drugEntities;
}
