package at.bovt.notification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class OrderPlacedEvent{
    private String orderNumber;
}
