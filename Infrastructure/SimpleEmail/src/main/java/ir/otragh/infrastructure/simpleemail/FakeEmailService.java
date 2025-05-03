package ir.otragh.infrastructure.simpleemail;

import ir.otragh.applicationservice.contracts.EmailService;
import ir.otragh.core.domain.users.valueobjects.Email;
import org.springframework.stereotype.Component;

@Component
public class FakeEmailService implements EmailService {
    @Override
    public void send(Email to, String body) {
        System.out.println("Email sent to " + to);
    }
}
