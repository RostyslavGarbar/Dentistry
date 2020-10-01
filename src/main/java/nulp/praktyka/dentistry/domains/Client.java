package nulp.praktyka.dentistry.domains;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Client extends Users { }
