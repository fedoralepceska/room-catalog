package mk.finki.ukim.emt.roomcatalog.config;

import mk.finki.ukim.emt.roomcatalog.domain.models.Room;
import mk.finki.ukim.emt.roomcatalog.domain.repository.RoomRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DataInitializer {
    private final RoomRepository roomRepository;

    public DataInitializer(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void initData() {
        Room r1 = Room.build("One-Bedroom apartment", Money.valueOf(Currency.MKD,600), 3);
        Room r2 = Room.build("Studio", Money.valueOf(Currency.MKD,400), 5);
        if (roomRepository.findAll().isEmpty()) {
            roomRepository.saveAll(Arrays.asList(r1, r2));
        }
    }
}
