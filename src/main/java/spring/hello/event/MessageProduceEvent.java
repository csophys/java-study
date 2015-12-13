package spring.hello.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by csophys on 15/12/13.
 */
public class MessageProduceEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageProduceEvent(Object source) {
        super(source);
    }


}
