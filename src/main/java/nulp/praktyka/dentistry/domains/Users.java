package nulp.praktyka.dentistry.domains;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotNull
    private String name;

    @Column(length = 50)
    @NotNull
    private String surname;

    @NotNull
    @Column(length = 50)
    private String fatherName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Column(length = 13)
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    @Column(unique=true)
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String userRole;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CreatedOrder> orders;
}
