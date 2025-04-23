package ir.otragh.core.domain.comments.entities;

import ir.otragh.core.domain.comments.events.CommentCreated;
import ir.otragh.core.domain.framework.entities.BaseEntity;
import lombok.Getter;

@Getter
public final class Comment extends BaseEntity<Long> {

    private String comment;
    private long rentId;

    private Comment(Long aLong, long rentId, String comment) {
        super(aLong);
        this.rentId = rentId;
        this.comment = comment;
    }

    public static Comment create(long id, long rentId, String comment) {
        Comment c = new Comment(id, rentId,comment);
        c.addDomainEvent(new CommentCreated(id));
        return c;
    }
}
