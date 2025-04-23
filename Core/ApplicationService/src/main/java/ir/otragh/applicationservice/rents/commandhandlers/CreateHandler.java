package ir.otragh.applicationservice.rents.commandhandlers;

import ir.otragh.applicationservice.amenities.repositories.AmenityRepository;
import ir.otragh.applicationservice.framework.commandhandlers.CommandHandler;
import ir.otragh.applicationservice.homes.repositories.HomeRepository;
import ir.otragh.applicationservice.users.repositories.UserRepository;
import ir.otragh.core.domain.amenities.entities.Amenity;
import ir.otragh.core.domain.homes.entities.Home;
import ir.otragh.core.domain.rents.commands.Create;
import ir.otragh.core.domain.rents.entities.Rent;
import ir.otragh.core.domain.rents.microtypes.EndDate;
import ir.otragh.core.domain.rents.microtypes.StartDate;
import ir.otragh.core.domain.users.entities.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CreateHandler implements CommandHandler<Create, Void> {

    private HomeRepository homeRepository;
    private AmenityRepository amenityRepository;
    private UserRepository userRepository;

    @Override
    public Void handle(Create command) {
        Home home = homeRepository.getReferenceById(command.homeId());
        User user = userRepository.getReferenceById(command.userId());
        List<Amenity> amenities = amenityRepository.findAllById(command.selectedAmenities());
        if (user != null)
            if (home != null)
                if (amenities.size() == command.selectedAmenities().size())
                    Rent.create(0, home, user, new StartDate(command.startRent()) , new EndDate(command.endRent()),
                            new LinkedList<>(amenities));
        return null;
    }
}
