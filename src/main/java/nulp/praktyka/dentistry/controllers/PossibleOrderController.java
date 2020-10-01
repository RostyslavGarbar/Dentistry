package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.PossibleOrderService.Dto.PossibleOrderDtoRequest;
import nulp.praktyka.dentistry.services.PossibleOrderService.Dto.PossibleOrderDtoResponse;
import nulp.praktyka.dentistry.services.PossibleOrderService.PossibleOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/slots")
public class PossibleOrderController {
    private final PossibleOrderService possibleOrderService;

    @GetMapping("/allPossibleOrdersByEmployee/{employeeId}")
    public List<PossibleOrderDtoResponse> getAllPossibleOrdersByEmployee(@PathVariable Long employeeId){
        List<PossibleOrderDtoResponse> p =  possibleOrderService.getPossibleOrdersByEmployeeId(employeeId);
        return possibleOrderService.getPossibleOrdersByEmployeeId(employeeId);
    }

    @GetMapping("/allActivePossibleOrdersByEmployee/{employeeId}")
    public List<PossibleOrderDtoResponse> getAllActivePossibleOrdersByEmployee(@PathVariable Long employeeId){
        List<PossibleOrderDtoResponse> p =  possibleOrderService.getPossibleOrdersByEmployeeId(employeeId);
        return possibleOrderService.getActivePossibleOrdersByEmployeeId(employeeId);
    }

    @PostMapping("/addSlot")
    public PossibleOrderDtoResponse addPossibleOrder(@RequestBody PossibleOrderDtoRequest possibleOrderDtoRequest){
        return possibleOrderService.addPossibleOrderForEmployee(possibleOrderDtoRequest);
    }

    @DeleteMapping("/deleteSlot/{possibleOrderId}")
    public void deletePossibleOrder(@PathVariable Long possibleOrderId){
        possibleOrderService.deletePossibleOrderForEmployee(possibleOrderId);
    }

}
