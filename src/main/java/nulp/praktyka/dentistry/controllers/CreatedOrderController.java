package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoRequest;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForAdmin;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForClient;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForEmployee;
import nulp.praktyka.dentistry.services.OrderService.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class CreatedOrderController {
    private final OrderService orderService;

    @GetMapping("/employeeOrders/allOrders")
    public List<CreatedOrderDtoResponseForAdmin> getAllOrdersByEmployeeId() {
        return orderService.getAllOrders();
    }

    @GetMapping("/employeeOrders/allOrders/{employeeId}")
    public List<CreatedOrderDtoResponseForEmployee> getAllOrdersByEmployeeId(@PathVariable Long employeeId) {
        return orderService.getAllOrdersByEmployeeId(employeeId);
    }

    @GetMapping("/clientOrders/allOrders/{clientId}")
    public List<CreatedOrderDtoResponseForClient> getAllOrdersByClientId(@PathVariable Long clientId) {
        return orderService.getAllOrdersByClientId(clientId);
    }

    @PostMapping("/clientOrders/create")
    public CreatedOrderDtoResponseForClient addOrder(@RequestBody CreatedOrderDtoRequest createdOrderDtoRequest) {
        return orderService.addOrder(createdOrderDtoRequest);
    }

    @DeleteMapping("/clientOrders/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
