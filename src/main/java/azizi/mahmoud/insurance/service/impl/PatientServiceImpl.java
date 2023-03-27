package azizi.mahmoud.insurance.service.impl;

import azizi.mahmoud.insurance.model.dto.PatientDto;
import azizi.mahmoud.insurance.model.entity.PatientEntity;
import azizi.mahmoud.insurance.repository.PatientRepository;
import azizi.mahmoud.insurance.service.api.IdentityInformationService;
import azizi.mahmoud.insurance.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private IdentityInformationService identityInformationService;

    @Override
    public PatientEntity register(PatientDto patientDto) throws Exception {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setIdentityInformationEntity(identityInformationService.checkAndSave(patientDto.getIdentityInformationEntity()));
        patientEntity.setMobile(patientDto.getMobile());
        patientEntity.setAddress(patientDto.getAddress());
        return patientRepository.save(patientEntity);
    }


}
