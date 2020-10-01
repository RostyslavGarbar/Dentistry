package nulp.praktyka.dentistry.repositories;

import nulp.praktyka.dentistry.domains.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> { }
