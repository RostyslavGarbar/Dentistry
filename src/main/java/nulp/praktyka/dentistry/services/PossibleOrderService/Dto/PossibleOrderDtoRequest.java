package nulp.praktyka.dentistry.services.PossibleOrderService.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class PossibleOrderDtoRequest {

    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Long employeeId;

}

