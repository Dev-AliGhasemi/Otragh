package ir.otragh.applicationservice.contracts;

import ir.otragh.core.domain.users.valueobjects.Email;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void send(Email to, String body);
}
