package nulp.praktyka.dentistry.domains;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "status", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CreatedOrder> statuses;
}
