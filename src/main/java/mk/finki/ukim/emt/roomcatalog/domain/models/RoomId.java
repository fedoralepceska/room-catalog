package mk.finki.ukim.emt.roomcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class RoomId extends DomainObjectId {

    private RoomId() {
        super(RoomId.randomId(RoomId.class).getId());
    }

    public RoomId(@NonNull String uuid) {
        super(uuid);
    }

    public static RoomId of(String uuid) {
        RoomId p = new RoomId(uuid);
        return p;
    }
}
