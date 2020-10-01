package nulp.praktyka.dentistry.services.ServiceService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.exception.EntityNotFoundException;
import nulp.praktyka.dentistry.repositories.ServiceRepository;
import nulp.praktyka.dentistry.services.ServiceService.Dto.ServiceDto;
import nulp.praktyka.dentistry.domains.Service;
import nulp.praktyka.dentistry.services.ServiceService.Mapper.ServiceMapper;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public List<ServiceDto> getAllServices(){
        List<Service> services = serviceRepository.findAll();
        return services.stream().map(serviceMapper::toDto).collect(Collectors.toList());
    }

    public ServiceDto addService(ServiceDto serviceDto){
        Service newService = serviceMapper.toEntity(serviceDto);
        return serviceMapper.toDto(serviceRepository.save(newService));
    }

    public void deleteServiceById(Long serviceId){
        serviceRepository.deleteById(serviceId);
    }

    public ServiceDto updateServiceById(ServiceDto serviceDto){
        serviceRepository.findById(serviceDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Service Not Found"));
        Service newService = serviceMapper.toEntity(serviceDto);
        return serviceMapper.toDto(serviceRepository.save(newService));
    }
}
