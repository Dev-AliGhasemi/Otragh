package ir.otragh.infrastructure.DALCommand.framework;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "outbox")
public class OutboxEvent {

    @Id
    @GeneratedValue
    private UUID id;

    private String aggregateType;
    private String aggregateId;
    private String type; // event type
    @Lob
    private String payload;

    private Instant createdAt;
    private boolean sent;

    // constructors, getters, setters
}
