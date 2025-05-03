package ir.otragh.applicationservice.rents.queries.getrent;

import ir.otragh.applicationservice.framework.queries.QueryHandler;
import ir.otragh.applicationservice.rents.repositories.RentRepository;
import ir.otragh.core.domain.rents.entities.Rent;
import org.springframework.stereotype.Component;

@Component("GetRentQueryHandler")
public class GetRentQueryHandler implements QueryHandler<GetRentQuery,RentResponse> {

    //The best practice is to separate application service for reading. And in reading application service can use hibernate directly.
    private RentRepository rentRepository;

    @Override
    public RentResponse handle(GetRentQuery query) {
        Rent rent = rentRepository.findById(query.rentId());
        //Map rent to RentResponse;
        return null;
    }
}
