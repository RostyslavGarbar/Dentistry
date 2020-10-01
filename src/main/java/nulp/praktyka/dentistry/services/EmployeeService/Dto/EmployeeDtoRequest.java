package nulp.praktyka.dentistry.services.EmployeeService.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoRequest;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDtoRequest extends ClientDtoRequest {
    private Long positionId;
}
