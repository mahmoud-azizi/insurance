package azizi.mahmoud.insurance.model.entity;

import azizi.mahmoud.insurance.model.enumeration.SpecializationEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DOCTOR")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDENTITY_ID", referencedColumnName = "ID", nullable = false)
    private IdentityInformationEntity identityInformationEntity;

    @Column(name = "MEDICAL_SYSTEM_NUMBER", nullable = false, length = 5)
    private String medicalSystemNumber;

    //تخصص
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SPECIALIZATION", nullable = false, length = 3)
    private SpecializationEnum specialization;

    @Column(length = 11)
    private String mobile;

    @Lob
    private byte[] stamp;

    @Lob
    private byte[] signature;
}
