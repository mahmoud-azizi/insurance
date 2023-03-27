package azizi.mahmoud.insurance.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PRESCRIPTION")
// نسخه
public class PrescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "ID", nullable = false)
    private DoctorEntity doctorEntity;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID",referencedColumnName = "ID", nullable = false)
    private PatientEntity patientEntity;

    // تاریخ نسخه
    @Column(name = "PERSCRIPTION_DATE", nullable = false)
    private Date prescriptionDate;

    private String note;

}
