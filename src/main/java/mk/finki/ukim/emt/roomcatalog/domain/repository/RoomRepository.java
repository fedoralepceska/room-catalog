package mk.finki.ukim.emt.roomcatalog.domain.repository;

import mk.finki.ukim.emt.roomcatalog.domain.models.Room;
import mk.finki.ukim.emt.roomcatalog.domain.models.RoomId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, RoomId> {
}
