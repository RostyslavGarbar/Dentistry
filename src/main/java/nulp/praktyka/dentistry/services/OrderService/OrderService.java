package nulp.praktyka.dentistry.services.OrderService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.domains.CreatedOrder;
import nulp.praktyka.dentistry.exception.EntityNotFoundException;
import nulp.praktyka.dentistry.repositories.CreatedOrderRepository;
import nulp.praktyka.dentistry.repositories.StatusRepository;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoRequest;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForAdmin;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForClient;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForEmployee;
import nulp.praktyka.dentistry.services.OrderService.Mapper.OrderMapper;
import nulp.praktyka.dentistry.services.PossibleOrderService.PossibleOrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CreatedOrderRepository createdOrderRepository;
    private final OrderMapper orderMapper;
    private final PossibleOrderService possibleOrderService;
    private final StatusRepository statusRepository;

    public List<CreatedOrderDtoResponseForAdmin> getAllOrders() {
        List<CreatedOrder> orders = createdOrderRepository.findAll();
        return orders.stream().map(orderMapper::toAdminDto).collect(Collectors.toList());
    }

    public List<CreatedOrderDtoResponseForClient> getAllOrdersByClientId(Long clientId) {
        List<CreatedOrder> clientOrders = createdOrderRepository.findOrdersByClientId(clientId);
        return clientOrders.stream().map(orderMapper::toClientDto).collect(Collectors.toList());
    }

    public List<CreatedOrderDtoResponseForEmployee> getAllOrdersByEmployeeId(Long employeeId) {
        List<CreatedOrder> employeeOrders = createdOrderRepository.findOrdersByEmployeeId(employeeId);
        return employeeOrders.stream().map(orderMapper::toEmployeeDto).collect(Collectors.toList());
    }

    public CreatedOrderDtoResponseForClient addOrder(CreatedOrderDtoRequest createdOrderDtoRequest) {
        CreatedOrder order = orderMapper.toEntity(createdOrderDtoRequest);
        Long possibleOrderId = possibleOrderService.getIdByNameAndTimeAndDate(createdOrderDtoRequest.getEmployeeId(),
                createdOrderDtoRequest.getDate(), createdOrderDtoRequest.getTime()).getId();
        order.setStatus(statusRepository.getOne(1L));
        possibleOrderService.deactivatePossibleOrder(possibleOrderId);
        return orderMapper.toClientDto(createdOrderRepository.save(order));
    }

    public void deleteOrder(Long orderId) {
        CreatedOrder order = createdOrderRepository.findById(orderId).orElseThrow(()->
                new EntityNotFoundException("Not Found!"));
        Long possibleOrderId = possibleOrderService.getIdByNameAndTimeAndDate(order.getEmployee().getId(),
                order.getDate(), order.getTime()).getId();
        possibleOrderService.activatePossibleOrder(possibleOrderId);
        createdOrderRepository.deleteById(orderId);
    }

    @Scheduled(fixedDelay = 1000L)
    public void changeStatus() {
        LocalTime current_time = LocalTime.now();
        LocalDate current_date = LocalDate.now();
        List<CreatedOrder> orders = createdOrderRepository.findAll();
        for (CreatedOrder order : orders) {
            if(order.getDate().compareTo(current_date) <= 0 && order.getTime().compareTo(current_time) <= 0) {
                order.setStatus(statusRepository.getOne(4L));
                createdOrderRepository.save(order);
            }
        }
    }
}
