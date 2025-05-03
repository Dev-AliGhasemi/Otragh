package ir.otragh.applicationservice.rents.repositories;

import ir.otragh.core.domain.rents.entities.Rent;

public interface RentRepository {
    Rent findById(long id);

    void save(Rent rent);
}
