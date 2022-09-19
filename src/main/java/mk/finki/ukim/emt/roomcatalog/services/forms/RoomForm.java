package mk.finki.ukim.emt.roomcatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class RoomForm {
    private String roomType;
    private Money price;
    private int sales;
}
