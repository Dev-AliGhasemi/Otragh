package ir.otragh.infrastructure.DALCommand.rent.repositories;

import ir.otragh.applicationservice.rents.repositories.RentRepository;
import ir.otragh.core.domain.rents.entities.Rent;
import ir.otragh.infrastructure.DALCommand.rent.entities.RentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RentRepositoryImpl implements RentRepository {

    private final JpaRentRepository jpaRentRepository;
    private final RentMapper rentMapper;

    @Override
    public Rent findById(long id) {
        return rentMapper.rentToDataRent(jpaRentRepository.findById(id));
    }

    @Override
    public void save(Rent rent) {
        //Do save
    }
}
