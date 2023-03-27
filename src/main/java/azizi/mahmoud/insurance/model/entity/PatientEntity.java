package azizi.mahmoud.insurance.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PATIENT")
// بیمار
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "IDENTITY_ID", referencedColumnName = "ID", nullable = false)
    private IdentityInformationEntity identityInformationEntity;

    @Column(length = 11)
    private String mobile;

    private String address;

}
