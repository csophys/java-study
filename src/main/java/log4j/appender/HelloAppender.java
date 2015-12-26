package log4j.appender;

import lombok.Setter;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by csophys on 15/12/26.
 */
@Setter
public class HelloAppender extends AppenderSkeleton {

    public  String namespace;
    public String topic;


    @Override
    protected void append(LoggingEvent event) {
        String message = this.getLayout().format(event);
        System.out.println(namespace + "," + topic + "," + message);
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
