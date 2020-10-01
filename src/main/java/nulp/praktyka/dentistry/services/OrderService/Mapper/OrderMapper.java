package nulp.praktyka.dentistry.services.OrderService.Mapper;

import nulp.praktyka.dentistry.domains.CreatedOrder;
import nulp.praktyka.dentistry.services.ClientService.Mapper.ClientMapper;
import nulp.praktyka.dentistry.services.EmployeeService.Mapper.EmployeeMapper;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoRequest;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForAdmin;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForClient;
import nulp.praktyka.dentistry.services.OrderService.Dto.CreatedOrderDtoResponseForEmployee;
import nulp.praktyka.dentistry.services.ServiceService.Mapper.ServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, EmployeeMapper.class, ServiceMapper.class})
public interface OrderMapper {

    @Mapping(target = "client",  source = "clientId")
    @Mapping(target = "employee",  source = "employeeId")
    @Mapping(target = "service", source = "serviceId")
    CreatedOrder toEntity(CreatedOrderDtoRequest createdOrderDtoRequest);

    @Mapping(target = "status", source = "status.name")
    CreatedOrderDtoResponseForClient toClientDto(CreatedOrder createdOrder);

    @Mapping(target = "status", source = "status.name")
    CreatedOrderDtoResponseForEmployee toEmployeeDto(CreatedOrder createdOrder);

    @Mapping(target = "status", source = "status.name")
    CreatedOrderDtoResponseForAdmin toAdminDto(CreatedOrder createdOrder);
}
