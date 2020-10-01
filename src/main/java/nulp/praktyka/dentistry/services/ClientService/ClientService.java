package nulp.praktyka.dentistry.services.ClientService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.exception.EntityNotFoundException;
import nulp.praktyka.dentistry.domains.Client;
import nulp.praktyka.dentistry.repositories.ClientRepository;
import nulp.praktyka.dentistry.repositories.UserRepository;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoRequest;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoResponse;
import nulp.praktyka.dentistry.services.ClientService.Mapper.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDtoResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::toDtoResponse).collect(Collectors.toList());
    }

    public ClientDtoResponse addClient(ClientDtoRequest clientDtoRequest) {
        Client newClient = clientMapper.toEntity(clientDtoRequest);
        newClient.setUserRole("client");
        return clientMapper.toDtoResponse(clientRepository.save(newClient));
    }

    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public ClientDtoResponse updateClient(ClientDtoRequest clientDtoRequest) {
        clientRepository.findById(clientDtoRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Not found"));
        Client client = clientMapper.toEntity(clientDtoRequest);
        client.setUserRole("client");
        return clientMapper.toDtoResponse(clientRepository.save(client));
    }
}
