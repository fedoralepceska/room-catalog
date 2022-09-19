package mk.finki.ukim.emt.roomcatalog.xport.rest;

import mk.finki.ukim.emt.roomcatalog.domain.models.Room;
import mk.finki.ukim.emt.roomcatalog.services.RoomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomResource {
    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAll(){
        return this.roomService.findAll();
    }
}
