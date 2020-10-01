package nulp.praktyka.dentistry.services.PossibleOrderService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.exception.EntityNotFoundException;
import nulp.praktyka.dentistry.domains.PossibleOrder;
import nulp.praktyka.dentistry.repositories.EmployeeRepository;
import nulp.praktyka.dentistry.repositories.PossibleOrdersRepository;
import nulp.praktyka.dentistry.services.PossibleOrderService.Dto.PossibleOrderDtoRequest;
import nulp.praktyka.dentistry.services.PossibleOrderService.Dto.PossibleOrderDtoResponse;
import nulp.praktyka.dentistry.services.PossibleOrderService.Mapper.PossibleOrderMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PossibleOrderService {
    private final PossibleOrdersRepository possibleOrdersRepository;
    private final PossibleOrderMapper possibleOrderMapper;

    public List<PossibleOrderDtoResponse> getPossibleOrdersByEmployeeId(Long employeeId){
        List<PossibleOrder> possibleOrders = possibleOrdersRepository.findPossibleOrdersByEmployeeId(employeeId);
        return possibleOrders.stream().map(possibleOrderMapper::toDto).collect(Collectors.toList());
    }

    public List<PossibleOrderDtoResponse> getActivePossibleOrdersByEmployeeId(Long employeeId){
        List<PossibleOrder> possibleOrders = possibleOrdersRepository.
                findPossibleOrdersByEmployeeIdAndIsEnableIsTrue(employeeId);
        return possibleOrders.stream().map(possibleOrderMapper::toDto).collect(Collectors.toList());
    }

    public PossibleOrderDtoResponse addPossibleOrderForEmployee(PossibleOrderDtoRequest possibleOrderDtoRequest){
        PossibleOrder newPossibleOrder = possibleOrderMapper.toEntity(possibleOrderDtoRequest);
        newPossibleOrder.setIsEnable(Boolean.TRUE);
        return possibleOrderMapper.toDto(possibleOrdersRepository.save(newPossibleOrder));
    }

    public void deletePossibleOrderForEmployee(Long possibleOrderId){
        possibleOrdersRepository.deleteById(possibleOrderId);
    }

    public void activatePossibleOrder(Long id) {
        PossibleOrder possibleOrder = possibleOrdersRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Possible Order Not Found!"));
        possibleOrder.setIsEnable(Boolean.TRUE);
        possibleOrdersRepository.save(possibleOrder);
    }

    public void deactivatePossibleOrder(Long id) {
        PossibleOrder possibleOrder = possibleOrdersRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Possible Order Not Found!"));
        possibleOrder.setIsEnable(Boolean.FALSE);
        possibleOrdersRepository.save(possibleOrder);
    }

    public PossibleOrder getIdByNameAndTimeAndDate(Long employeeId, LocalDate date, LocalTime time) {
        return possibleOrdersRepository.findByEmployee_IdAndDateAndTime(employeeId, date, time);
    }

    @Scheduled(fixedDelay = 1000L)
    public void disableUnusedPossibleOrders() {
        LocalTime current_time = LocalTime.now();
        LocalDate current_date = LocalDate.now();
        List<PossibleOrder> possibleOrders = possibleOrdersRepository.findAll();
        for(PossibleOrder slot : possibleOrders) {
            if (slot.getDate().compareTo(current_date) <= 0 &&
                    slot.getTime().compareTo(current_time) <= 0 && slot.getIsEnable()) {
                possibleOrdersRepository.deleteById(slot.getId());
            }
        }
    }
}
