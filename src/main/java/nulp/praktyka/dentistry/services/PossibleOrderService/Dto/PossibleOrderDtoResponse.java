package nulp.praktyka.dentistry.services.PossibleOrderService.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nulp.praktyka.dentistry.domains.PossibleOrder;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoResponse;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class PossibleOrderDtoResponse {

    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Boolean isEnable;

    private EmployeeDtoResponse employee;

}
