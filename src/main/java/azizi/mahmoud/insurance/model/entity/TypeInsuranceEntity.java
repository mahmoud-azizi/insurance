package azizi.mahmoud.insurance.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TYPE_INSURANCE")
// انواع بیمه
public class TypeInsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //درصد سهم بیمه
    @Column(nullable = false)
    private Short percentage;
}
