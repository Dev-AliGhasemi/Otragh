package ir.otragh.applicationservice.homes.repositories;

import ir.otragh.core.domain.homes.entities.Home;
import ir.otragh.core.domain.rents.valueobjects.DateRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
    Home findHomeById(Long id);

    boolean existsByIdAnAndLastReservedOnUTCBetween(Long id, Date start, Date end);
}
