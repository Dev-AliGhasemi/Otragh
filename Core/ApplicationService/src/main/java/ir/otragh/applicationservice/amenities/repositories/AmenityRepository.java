package ir.otragh.applicationservice.amenities.repositories;

import ir.otragh.core.domain.amenities.entities.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
