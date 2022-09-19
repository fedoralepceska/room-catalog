package mk.finki.ukim.emt.roomcatalog.services.impl;

import mk.finki.ukim.emt.roomcatalog.domain.exceptions.RoomNotFoundException;
import mk.finki.ukim.emt.roomcatalog.domain.models.Room;
import mk.finki.ukim.emt.roomcatalog.domain.models.RoomId;
import mk.finki.ukim.emt.roomcatalog.domain.repository.RoomRepository;
import mk.finki.ukim.emt.roomcatalog.services.RoomService;
import mk.finki.ukim.emt.roomcatalog.services.forms.RoomForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findById(RoomId id) {
        return this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

    @Override
    public Room createRoom(RoomForm form) {
        Room room = Room.build(form.getRoomType(), form.getPrice(), form.getSales());
        this.roomRepository.save(room);
        return room;
    }

    @Override
    public Room orderItemCreated(RoomId id, int quantity) {
        Room room = this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        room.addSales(quantity);
        roomRepository.saveAndFlush(room);
        return room;
    }

    @Override
    public Room orderItemRemoved(RoomId id, int quantity) {
        Room room = this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        room.removeSales(quantity);
        roomRepository.saveAndFlush(room);
        return room;
    }

    @Override
    public List<Room> findAll() {
        return this.roomRepository.findAll();
    }
}
