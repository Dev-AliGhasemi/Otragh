package ir.otragh.applicationservice.rents.repositories;

import ir.otragh.core.domain.rents.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}
