package ir.otragh.applicationservice.rents.repositories;

import ir.otragh.core.domain.homes.entities.Home;
import ir.otragh.core.domain.rents.entities.Rent;
import ir.otragh.core.domain.rents.valueobjects.DateRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    @Query("""
    SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END 
    FROM Home h
    WHERE h.id = :home.id
    AND (r.lastReservedOnUTC <= :duration.end AND r.lastReservedOnUTC >= :duration.start)
    """)
    boolean isOverlapping(@Param("home") Home home, @Param("duration") DateRange duration);
}
