package azizi.mahmoud.insurance.model.dto;

import azizi.mahmoud.insurance.model.entity.IdentityInformationEntity;
import azizi.mahmoud.insurance.model.enumeration.SpecializationEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

@Getter
@Setter
public class DoctorDto {
    private IdentityInformationEntity identityInformationEntity;

    private String medicalSystemNumber;

    //تخصص
    @Enumerated(EnumType.ORDINAL)
    private SpecializationEnum specialization;

    private String mobile;

    @Lob
    private byte[] stamp;

    @Lob
    private byte[] signature;
}
