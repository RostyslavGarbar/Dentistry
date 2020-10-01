package nulp.praktyka.dentistry.services.OrderService.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoResponse;
import nulp.praktyka.dentistry.services.ServiceService.Dto.ServiceDto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class CreatedOrderDtoResponseForClient {
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private String status;

    private ServiceDto service;

    private EmployeeDtoResponse employee;

}
