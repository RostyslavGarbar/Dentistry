package nulp.praktyka.dentistry.services.ClientService.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClientDtoRequest {
    private Long id;

    private String name;

    private String surname;

    private String fatherName;

    private LocalDate birthDate;

    private String phoneNumber;

    private String email;

    private String login;

    private String password;
}
