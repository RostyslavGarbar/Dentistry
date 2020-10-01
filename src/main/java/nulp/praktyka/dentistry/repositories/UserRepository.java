package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByLoginAndPassword(String login, String password);

}
