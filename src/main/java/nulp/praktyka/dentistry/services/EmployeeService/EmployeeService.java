package nulp.praktyka.dentistry.services.EmployeeService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.exception.EntityNotFoundException;
import nulp.praktyka.dentistry.domains.Employee;
import nulp.praktyka.dentistry.repositories.EmployeeRepository;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoRequest;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoResponse;
import nulp.praktyka.dentistry.services.EmployeeService.Mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDtoResponse> getAllEmployees(){
        List<Employee> employees = employeeRepository.getEmployeeInfo();
        return employees.stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    public EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest){
        Employee newEmployee = employeeMapper.toEntity(employeeDtoRequest);
        newEmployee.setUserRole("dentist");
        return employeeMapper.toDto(employeeRepository.save(newEmployee));
    }

    public void deleteEmployeeById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public EmployeeDtoResponse updateEmployee(EmployeeDtoRequest employeeDtoRequest){
        employeeRepository.findById(employeeDtoRequest.getId()).orElseThrow(
                () -> new EntityNotFoundException("Employee not found!"));
        Employee employee = employeeMapper.toEntity(employeeDtoRequest);
        employee.setUserRole("dentist");
        return employeeMapper.toDto(employeeRepository.save(employee));
    }
}
