package mk.finki.ukim.emt.roomcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.roomcatalog.domain.models.RoomId;
import mk.finki.ukim.emt.roomcatalog.services.RoomService;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.event.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.event.order.OrderItemCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomEventListener {
    private final RoomService roomService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreated(String jsonMessage){
        try{
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            roomService.orderItemCreated(RoomId.of(event.getRoomId()), event.getQuantity());
        }catch (Exception e){

        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
    public void consumeOrderItemRemoved(String jsonMessage){
        try{
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            roomService.orderItemRemoved(RoomId.of(event.getRoomId()), event.getQuantity());
        }catch (Exception e){

        }
    }
}
