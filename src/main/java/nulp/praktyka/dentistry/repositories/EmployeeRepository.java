package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT empl FROM Employee empl")
    List<Employee> getEmployeeInfo();
}
