package azizi.mahmoud.insurance.model.entity;

import azizi.mahmoud.insurance.model.enumeration.SpecializationEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DRUG")
//دارو
public class DrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    //دسته بندی دارو روی تخصص
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SPECIALIZATION", nullable = false, length = 3)
    private SpecializationEnum specialization;

    @Transient
    private Short count;
}
