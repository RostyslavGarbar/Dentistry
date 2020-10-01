package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> { }
