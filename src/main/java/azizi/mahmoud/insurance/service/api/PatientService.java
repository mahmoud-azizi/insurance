package azizi.mahmoud.insurance.service.api;

import azizi.mahmoud.insurance.model.dto.PatientDto;
import azizi.mahmoud.insurance.model.entity.PatientEntity;

public interface PatientService {
    PatientEntity register(PatientDto patientDto) throws Exception;

}
