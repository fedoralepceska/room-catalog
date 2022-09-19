package mk.finki.ukim.emt.roomcatalog.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

public class Quantity implements ValueObject {
    private final int quantity;
    protected Quantity(){
        this.quantity=0;
    }
}
