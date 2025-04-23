package ir.otragh.applicationservice.rents.commandhandlers;

import ir.otragh.applicationservice.framework.commandhandlers.CommandHandler;
import ir.otragh.applicationservice.rents.repositories.RentRepository;
import ir.otragh.core.domain.rents.commands.Pay;
import ir.otragh.core.domain.rents.entities.Rent;
import org.springframework.stereotype.Component;

@Component
public class PayHandler implements CommandHandler<Pay,Void> {

    private RentRepository rentRepository;

    @Override
    public Void handle(Pay command) {
        Rent rent = rentRepository.getReferenceById(command.rentId());
        if (rent != null)
            rent.pay();
        return null;
    }
}
