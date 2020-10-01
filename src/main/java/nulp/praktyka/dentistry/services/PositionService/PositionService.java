package nulp.praktyka.dentistry.services.PositionService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.domains.Position;
import nulp.praktyka.dentistry.repositories.PositionRepository;
import nulp.praktyka.dentistry.services.PositionService.Dto.PositionDto;
import nulp.praktyka.dentistry.services.PositionService.Mapper.PositionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;
    
    public List<PositionDto> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream().map(positionMapper::toDto).collect(Collectors.toList());
    }
}
