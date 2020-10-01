package nulp.praktyka.dentistry.services.ServiceService.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDto {
    private Long id;

    private String name;

    private String description;

    private Double price;
}
