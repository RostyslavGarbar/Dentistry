package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> { }
