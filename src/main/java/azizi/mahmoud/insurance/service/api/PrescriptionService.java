package azizi.mahmoud.insurance.service.api;

import azizi.mahmoud.insurance.model.dto.PrescriptionDto;
import azizi.mahmoud.insurance.model.entity.PrescriptionEntity;

public interface PrescriptionService {
    PrescriptionEntity writePrescription(PrescriptionDto prescriptionDto) throws Exception;
}
