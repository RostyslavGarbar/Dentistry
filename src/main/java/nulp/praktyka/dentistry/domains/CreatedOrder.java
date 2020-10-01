package nulp.praktyka.dentistry.domains;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreatedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @NotNull
    @ManyToOne
    private Client client;

    @NotNull
    @ManyToOne
    private Employee employee;

    @NotNull
    @ManyToOne
    private Service service;

    @ManyToOne
    @NotNull
    private Status status;
}
