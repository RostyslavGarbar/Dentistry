package nulp.praktyka.dentistry.services.EmployeeService.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoResponse;
import nulp.praktyka.dentistry.services.ClientService.Mapper.ClientMapper;
import nulp.praktyka.dentistry.services.UserService.Dto.UserDtoResponse;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDtoResponse extends UserDtoResponse {

    private String position;

}