package azizi.mahmoud.insurance.service.impl;

import azizi.mahmoud.insurance.model.dto.DoctorDto;
import azizi.mahmoud.insurance.model.entity.DoctorEntity;
import azizi.mahmoud.insurance.repository.DoctorRepository;
import azizi.mahmoud.insurance.service.api.DoctorService;
import azizi.mahmoud.insurance.service.api.IdentityInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private IdentityInformationService identityInformationService;

    @Override
    public DoctorEntity register(DoctorDto doctorDto) throws Exception {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setIdentityInformationEntity(identityInformationService.checkAndSave(doctorDto.getIdentityInformationEntity()));
        doctorEntity.setMobile(doctorDto.getMobile());
        doctorEntity.setMedicalSystemNumber(checkMedicalSystemNumber(doctorDto.getMedicalSystemNumber()));
        doctorEntity.setSpecialization(doctorDto.getSpecialization());
        return doctorRepository.save(doctorEntity);
    }

    private String checkMedicalSystemNumber(String medicalSystemNumber) throws Exception {
        if (medicalSystemNumber == null || medicalSystemNumber.length() != 5) {
            throw new Exception("شماره نظام پزشکی وارد شده اشتباه است");
        }
        return medicalSystemNumber;
    }
}
;