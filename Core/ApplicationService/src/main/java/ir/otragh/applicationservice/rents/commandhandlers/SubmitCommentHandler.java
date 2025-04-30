package ir.otragh.applicationservice.rents.commandhandlers;

import ir.otragh.applicationservice.framework.commandhandlers.CommandHandler;
import ir.otragh.applicationservice.rents.repositories.RentRepository;
import ir.otragh.core.domain.comments.entities.Comment;
import ir.otragh.core.domain.rents.commands.SubmitComment;
import ir.otragh.core.domain.rents.entities.Rent;
import org.springframework.stereotype.Component;

@Component
public class SubmitCommentHandler implements CommandHandler<SubmitComment,Void> {

    private RentRepository rentRepository;
    //Add To Datastore here or not?

    @Override
    public Void handle(SubmitComment command) {
        Rent rent = rentRepository.getReferenceById(command.rentId());
        if (rent != null)
            rent.submitComment(Comment.create(0,command.rentId(),command.comment()));
        return null;
    }
}
