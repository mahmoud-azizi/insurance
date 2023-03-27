package azizi.mahmoud.insurance.service.api;

import azizi.mahmoud.insurance.model.dto.DoctorDto;
import azizi.mahmoud.insurance.model.entity.DoctorEntity;

public interface DoctorService {
    DoctorEntity register(DoctorDto doctorDto) throws Exception;
}
