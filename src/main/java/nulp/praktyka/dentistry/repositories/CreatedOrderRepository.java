package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.CreatedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatedOrderRepository extends JpaRepository<CreatedOrder, Long> {

    List<CreatedOrder> findOrdersByClientId(Long clientId);

    List<CreatedOrder> findOrdersByEmployeeId(Long employeeId);

}
