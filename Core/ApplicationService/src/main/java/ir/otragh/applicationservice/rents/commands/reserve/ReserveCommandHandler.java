package ir.otragh.applicationservice.rents.commands.reserve;

import ir.otragh.applicationservice.amenities.repositories.AmenityRepository;
import ir.otragh.applicationservice.contracts.DateTimePicker;
import ir.otragh.applicationservice.contracts.IdGenerator;
import ir.otragh.applicationservice.framework.commands.data.CommandHandler;
import ir.otragh.applicationservice.homes.repositories.HomeRepository;
import ir.otragh.applicationservice.rents.repositories.RentRepository;
import ir.otragh.applicationservice.users.repositories.UserRepository;
import ir.otragh.core.domain.amenities.entities.Amenity;
import ir.otragh.core.domain.framework.Result;
import ir.otragh.core.domain.homes.errors.HomeError;
import ir.otragh.core.domain.rents.entities.Rent;
import ir.otragh.core.domain.rents.entities.RentErrors;
import ir.otragh.core.domain.rents.valueobjects.DateRange;
import ir.otragh.core.domain.users.errors.UserError;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.context.event.EventListener;

import java.util.List;

@AllArgsConstructor
@Validated
public class ReserveCommandHandler implements CommandHandler<ReserveCommand, Result> {

    private IdGenerator idGenerator;
    private UserRepository userRepository;
    private HomeRepository homeRepository;
    private RentRepository rentRepository;
    private AmenityRepository amenityRepository;
    private DateTimePicker dateTimePicker;

    @Override
    @Transactional
    @EventListener
    public Result handle(@Valid ReserveCommand command) {
        var user = userRepository.findUserById(command.userId());
        if (user == null)
            return Result.failure(UserError.NOT_FOUND);
        var home = homeRepository.findHomeById(command.homeId());
        if (home == null)
            return Result.failure(HomeError.NOT_FOUND);

        DateRange duration = new DateRange(command.startDate(), command.endDate());

        if (rentRepository.isOverlapping(home,duration))
            return Result.failure(RentErrors.OVERLAP);

        List<Amenity> amenities = amenityRepository.findAllById(home.getAmenities());

        var rent = Rent.reserve(idGenerator.generateId(), home, user.getId(), duration, dateTimePicker.getUTCNow(), amenities);
        rentRepository.save(rent);
        return Result.success(rent.getId());
    }
}
