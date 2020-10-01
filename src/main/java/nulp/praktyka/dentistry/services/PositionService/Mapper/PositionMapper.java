package nulp.praktyka.dentistry.services.PositionService.Mapper;

import nulp.praktyka.dentistry.domains.Position;
import nulp.praktyka.dentistry.services.PositionService.Dto.PositionDto;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    PositionDto toDto(Position position);

    default Position fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Position position = new Position();
        position.setId(id);
        return position;
    }
}
