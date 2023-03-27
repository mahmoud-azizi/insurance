package azizi.mahmoud.insurance.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PATIENT_MEDICATION")
// داروهای نسخه بیمار
public class PatientMedicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSCRIPTION_ID", referencedColumnName = "ID", nullable = false)
    private PrescriptionEntity prescriptionEntity;

    @ManyToOne
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", nullable = false)
    private DrugEntity drugEntity;

    @Column(length = 4, nullable = false)
    private Short count;

    // درصد لحاظ شده بیمه
    @Column(length = 3)
    private Short percentage;

}
