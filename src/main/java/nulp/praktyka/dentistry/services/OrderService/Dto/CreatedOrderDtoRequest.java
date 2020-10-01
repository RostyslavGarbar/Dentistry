package nulp.praktyka.dentistry.services.OrderService.Dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nulp.praktyka.dentistry.domains.Client;
import nulp.praktyka.dentistry.domains.Employee;
import nulp.praktyka.dentistry.domains.Service;
import nulp.praktyka.dentistry.domains.Status;

import javax.persistence.ManyToOne;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class CreatedOrderDtoRequest {
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Long clientId;

    private Long employeeId;

    private Long serviceId;

}
