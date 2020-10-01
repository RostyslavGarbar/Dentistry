package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.ClientService.ClientService;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoRequest;
import nulp.praktyka.dentistry.services.ClientService.Dto.ClientDtoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/allClients")
    public List<ClientDtoResponse> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/create")
    public ClientDtoResponse createClient(@RequestBody ClientDtoRequest clientDtoRequest){
        return clientService.addClient(clientDtoRequest);
    }

    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable Long clientId){
        clientService.deleteClientById(clientId);
    }

    @PostMapping("/update")
    public ClientDtoResponse updateClient(@RequestBody ClientDtoRequest clientDtoRequest){
        return clientService.updateClient(clientDtoRequest);
    }
}
