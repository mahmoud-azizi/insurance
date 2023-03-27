package azizi.mahmoud.insurance.service.api;

import azizi.mahmoud.insurance.model.entity.IdentityInformationEntity;

public interface IdentityInformationService {
    IdentityInformationEntity checkAndSave(IdentityInformationEntity identityInformationEntity) throws Exception;
}
