package ir.otragh.infrastructure.DALCommand.rent.repositories;

import ir.otragh.infrastructure.DALCommand.rent.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRentRepository extends JpaRepository<Rent,Long> {
    Rent findById(long id);
}
