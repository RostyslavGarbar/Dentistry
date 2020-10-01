package nulp.praktyka.dentistry.services.PossibleOrderService.Mapper;

import nulp.praktyka.dentistry.domains.PossibleOrder;
import nulp.praktyka.dentistry.services.EmployeeService.Mapper.EmployeeMapper;
import nulp.praktyka.dentistry.services.PossibleOrderService.Dto.PossibleOrderDtoRequest;
import nulp.praktyka.dentistry.services.PossibleOrderService.Dto.PossibleOrderDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface PossibleOrderMapper {

    @Mapping(target= "employee", source = "employeeId")
    PossibleOrder toEntity(PossibleOrderDtoRequest possibleOrderDtoRequest);

    PossibleOrderDtoResponse toDto(PossibleOrder possibleOrder);

}
