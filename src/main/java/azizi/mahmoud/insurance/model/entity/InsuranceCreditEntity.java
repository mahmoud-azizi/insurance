package azizi.mahmoud.insurance.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "INSURANCE_CREDIT")
// اعتبار بیمه شدگان
public class InsuranceCreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDENTITY_ID", referencedColumnName = "ID", nullable = false)
    private IdentityInformationEntity identityInformationEntity;

    @ManyToOne
    @JoinColumn(name = "TYEP_INSURANCE_ID", referencedColumnName = "ID", nullable = false)
    private TypeInsuranceEntity typeInsuranceEntity;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

}
