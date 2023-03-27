package azizi.mahmoud.insurance.service.impl;

import azizi.mahmoud.insurance.model.dto.PrescriptionDto;
import azizi.mahmoud.insurance.model.entity.*;
import azizi.mahmoud.insurance.model.enumeration.SpecializationEnum;
import azizi.mahmoud.insurance.repository.*;
import azizi.mahmoud.insurance.service.api.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private InsuranceCreditRepository insuranceCreditRepository;

    @Autowired
    private PatientMedicationRepository patientMedicationRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public PrescriptionEntity writePrescription(PrescriptionDto prescriptionDto) throws Exception {
        //ثبت اطلاعات لازم در نسخه
        DoctorEntity doctorEntity = getDoctorById(prescriptionDto.getDoctorId());
        PatientEntity patientEntity = getPatientById(prescriptionDto.getPatientId());
        PrescriptionEntity prescriptionNew = new PrescriptionEntity();
        prescriptionNew.setDoctorEntity(doctorEntity);
        prescriptionNew.setPatientEntity(patientEntity);
        prescriptionNew.setPrescriptionDate(new Date());
        prescriptionNew.setNote(prescriptionDto.getNote());
        PrescriptionEntity prescriptionEntity = prescriptionRepository.save(prescriptionNew);

        // ثبت داروهای نسخه
        if (prescriptionDto.getDrugEntities()!=null) {
            for (DrugEntity item : prescriptionDto.getDrugEntities()) {
                // بدست آوردن رکورد دارو با شناسه دارو دریافت شده از کاربر
                DrugEntity drugEntity = drugRepository.findById(item.getId()).get();

                // بدست آوردن درصد بیمه
                Short percentage = getPercentage(drugEntity.getSpecialization(), patientEntity.getIdentityInformationEntity(), doctorEntity.getSpecialization());

                PatientMedicationEntity patientMedicationEntity = new PatientMedicationEntity();
                patientMedicationEntity.setPrescriptionEntity(prescriptionEntity);
                patientMedicationEntity.setDrugEntity(drugEntity);
                patientMedicationEntity.setPercentage(percentage);
                patientMedicationEntity.setCount(item.getCount());
                patientMedicationRepository.save(patientMedicationEntity);
            }
        }
        return prescriptionEntity;
    }

    private Short getPercentage(SpecializationEnum drugSpecialization, IdentityInformationEntity identityInformationEntity, SpecializationEnum doctorSpecialization) {
        if (!drugSpecialization.equals(doctorSpecialization)) {
            return 0; // در صورتی که دارو توسط متخصص آن تجویز نشده بود
        }
        InsuranceCreditEntity insuranceCreditEntity = findInsuranceCredit(identityInformationEntity.getNationalCode());
        if (insuranceCreditEntity == null) {
            return null; // در صورتی که بیمه شده اعتبار نداشت
        }
        long currentTime = new Date().getTime();
        if (insuranceCreditEntity.getEndDate().getTime()<currentTime) {
            return null; // در صورتی که بیمه شده اعتبار نداشت
        }
        return insuranceCreditEntity.getTypeInsuranceEntity().getPercentage(); // برگشت درصد ثبت شده برای بیمه شده
    }

    private InsuranceCreditEntity findInsuranceCredit(String nationalCode) {
       return insuranceCreditRepository.findByNationalCode(nationalCode);
    }

    private PatientEntity getPatientById(Long patientId) throws Exception {
        Optional<PatientEntity> patientbyId = patientRepository.findById(patientId);
        if (patientbyId.isPresent()) {
            return patientbyId.get();
        } else {
            throw new Exception("شناسه بیمار بدرستی وارد نشده است.");
        }
    }

    private DoctorEntity getDoctorById(Long doctorId) throws Exception {
        Optional<DoctorEntity> doctorById = doctorRepository.findById(doctorId);
        if (doctorById.isPresent()) {
            return doctorById.get();
        } else {
            throw new Exception("شناسه دکتر بدرستی وارد نشده است.");
        }
    }
}
