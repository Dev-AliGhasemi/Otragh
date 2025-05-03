package ir.otragh.applicationservice.rents.events.reserved;

import ir.otragh.applicationservice.contracts.EmailService;
import ir.otragh.applicationservice.framework.events.EventHandler;
import ir.otragh.applicationservice.rents.repositories.RentRepository;
import ir.otragh.applicationservice.users.repositories.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RentReservedHandler implements EventHandler<RentReserved> {

    private RentRepository rentRepository;
    private UserRepository userRepository;
    private EmailService emailService;

    @Override
    @EventListener
    public void handle(RentReserved event) {
        var rent = rentRepository.findById(event.id());
        if (rent == null)
            return;
        var user = userRepository.findUserById(rent.getUserId());
        if (user == null)
            return;
        emailService.send(user.getEmail(),"Your home reserved.");
    }
}
