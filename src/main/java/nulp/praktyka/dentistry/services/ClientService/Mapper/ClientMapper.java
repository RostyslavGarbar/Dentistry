package nulp.praktyka.dentistry.services.ClientService.Mapper;

import nulp.praktyka.dentistry.domains.Client;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoRequest;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoResponse;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientDtoRequest clientDtoRequest);

    ClientDtoResponse toDtoResponse(Client client);

    default Client fromId(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }

}
