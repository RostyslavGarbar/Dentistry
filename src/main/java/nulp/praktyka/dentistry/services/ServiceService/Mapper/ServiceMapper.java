package nulp.praktyka.dentistry.services.ServiceService.Mapper;

import nulp.praktyka.dentistry.domains.Service;
import nulp.praktyka.dentistry.services.ServiceService.Dto.ServiceDto;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    Service toEntity(ServiceDto serviceDto);

    ServiceDto toDto(Service service);

    default Service fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Service service = new Service();
        service.setId(id);
        return service;
    }

}
