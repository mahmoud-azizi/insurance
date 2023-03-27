package azizi.mahmoud.insurance.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "IDENTITY_INFORMATION")
// اطلاعات هویتی
public class IdentityInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NATIONAL_CODE", nullable = false, length = 10)
    private String nationalCode;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
}
