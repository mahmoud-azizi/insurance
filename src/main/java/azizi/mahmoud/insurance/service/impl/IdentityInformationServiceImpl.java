package azizi.mahmoud.insurance.service.impl;

import azizi.mahmoud.insurance.model.entity.IdentityInformationEntity;
import azizi.mahmoud.insurance.repository.IdentityInformationRepository;
import azizi.mahmoud.insurance.service.api.IdentityInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityInformationServiceImpl implements IdentityInformationService {
    @Autowired
    private IdentityInformationRepository identityInformationRepository;

    @Override
    public IdentityInformationEntity checkAndSave(IdentityInformationEntity identityInformationEntity) throws Exception {
        String nationalCode = checkNationalCode(identityInformationEntity.getNationalCode());
        IdentityInformationEntity byNationalCode = identityInformationRepository.findByNationalCode(nationalCode);
        if (byNationalCode != null) {
            return byNationalCode;
        } else {
            return identityInformationRepository.save(identityInformationEntity);
        }
    }

    private String checkNationalCode(String nationalCode) throws Exception {
        if (nationalCode == null || nationalCode.length() != 10) {
            throw new Exception("مقدار کدملی بدرستی وارد نشده است.");
        }
        return nationalCode;
    }
}
