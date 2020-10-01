package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.PossibleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface PossibleOrdersRepository extends JpaRepository<PossibleOrder, Long> {

    List<PossibleOrder> findPossibleOrdersByEmployeeId(Long employeeId);

    List<PossibleOrder> findPossibleOrdersByEmployeeIdAndIsEnableIsTrue(Long employeeId);

    @Query(value="SELECT * FROM possible_order WHERE employee_id = ?1 AND date = ?2 AND time = ?3", nativeQuery = true)
    PossibleOrder findByEmployee_IdAndDateAndTime(Long employeeId, LocalDate date, LocalTime time);

}
