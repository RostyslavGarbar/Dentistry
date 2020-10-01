package nulp.praktyka.dentistry.services.EmployeeService.Mapper;

import nulp.praktyka.dentistry.domains.Employee;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoRequest;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoResponse;
import nulp.praktyka.dentistry.services.PositionService.Mapper.PositionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {PositionMapper.class})
public interface EmployeeMapper {

    @Mapping(target = "position", source = "positionId")
    Employee toEntity(EmployeeDtoRequest employeeDtoRequest);

    @Mapping(target = "position", source = "position.name")
    EmployeeDtoResponse toDto(Employee employee);

    default Employee fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
