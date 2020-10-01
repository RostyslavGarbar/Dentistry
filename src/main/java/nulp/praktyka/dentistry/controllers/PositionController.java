package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.PositionService.Dto.PositionDto;
import nulp.praktyka.dentistry.services.PositionService.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/position")
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/allPositions")
    public List<PositionDto> getAllPositions() {
        return positionService.getAllPositions();
    }
}
