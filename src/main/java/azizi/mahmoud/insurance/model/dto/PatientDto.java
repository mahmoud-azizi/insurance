package azizi.mahmoud.insurance.model.dto;

import azizi.mahmoud.insurance.model.entity.IdentityInformationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {
    private IdentityInformationEntity identityInformationEntity;

    private String mobile;

    private String address;
}
