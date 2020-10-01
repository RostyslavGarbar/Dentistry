package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.ServiceService.Dto.ServiceDto;
import nulp.praktyka.dentistry.services.ServiceService.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service")
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping("/allServices")
    public List<ServiceDto> getAllServices(){
        return serviceService.getAllServices();
    }

    @PostMapping("/create")
    public ServiceDto createService(@RequestBody ServiceDto serviceDTO){
        return serviceService.addService(serviceDTO);
    }

    @DeleteMapping("/delete/{serviceId}")
    public void deleteService(@PathVariable Long serviceId){
        serviceService.deleteServiceById(serviceId);
    }

    @PostMapping("/update")
    public ServiceDto updateService(@RequestBody ServiceDto serviceDTO){
        return serviceService.updateServiceById(serviceDTO);
    }
}
