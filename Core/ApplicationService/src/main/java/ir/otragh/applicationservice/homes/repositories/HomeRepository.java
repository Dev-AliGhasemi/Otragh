package ir.otragh.applicationservice.homes.repositories;

import ir.otragh.core.domain.homes.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
}
