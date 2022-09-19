package mk.finki.ukim.emt.roomcatalog.domain.models;

import lombok.Getter;
import mk.finki.ukim.emt.roomcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "rooms")
public class Room extends AbstractEntity<RoomId> {
    private Room(){
        super(RoomId.randomId(RoomId.class));
    }
    private String roomType;
    private Quantity quantity;
    private Money pricePerNight;
    private int sales;

    public static Room build(String roomType, Money pricePerNight, int sales) {
        Room room = new Room();
        room.pricePerNight = pricePerNight;
        room.roomType = roomType;
        room.sales = sales;
        return room;
    }

    public void addSales(int quantity){
        this.sales = this.sales + quantity;
    }

    public void removeSales(int quantity){
        this.sales = this.sales - quantity;
    }
}

