package mk.finki.ukim.emt.roomcatalog.services;

import mk.finki.ukim.emt.roomcatalog.domain.models.Room;
import mk.finki.ukim.emt.roomcatalog.domain.models.RoomId;
import mk.finki.ukim.emt.roomcatalog.services.forms.RoomForm;

import java.util.List;

public interface RoomService {
    Room findById(RoomId id);
    Room createRoom(RoomForm form);
    Room orderItemCreated(RoomId id, int quantity);
    Room orderItemRemoved(RoomId id, int quantity);
    List<Room> findAll();
}
