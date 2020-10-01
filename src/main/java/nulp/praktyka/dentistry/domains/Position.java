package nulp.praktyka.dentistry.domains;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employees;
}
