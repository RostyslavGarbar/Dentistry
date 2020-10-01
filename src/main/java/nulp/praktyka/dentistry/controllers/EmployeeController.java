package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoRequest;
import nulp.praktyka.dentistry.services.EmployeeService.Dto.EmployeeDtoResponse;
import nulp.praktyka.dentistry.services.EmployeeService.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public List<EmployeeDtoResponse> getAllEmployees(){ return employeeService.getAllEmployees(); }

    @PostMapping("/create")
    public EmployeeDtoResponse addEmployee(@RequestBody EmployeeDtoRequest employeeDtoRequest){
        return employeeService.addEmployee(employeeDtoRequest);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @PostMapping("/update")
    public EmployeeDtoResponse updateEmployee(@RequestBody EmployeeDtoRequest employeeDtoRequest){
        return employeeService.updateEmployee(employeeDtoRequest);
    }
}
