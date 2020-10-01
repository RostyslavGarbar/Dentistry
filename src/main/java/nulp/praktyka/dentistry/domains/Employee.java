package nulp.praktyka.dentistry.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Users {

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PossibleOrder> possibleOrders;

    @ManyToOne
    private Position position;

}
