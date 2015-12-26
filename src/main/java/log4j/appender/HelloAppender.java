package log4j.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by csophys on 15/12/26.
 */
public class HelloAppender extends AppenderSkeleton {
    public  String namespace;
    public String topic;


    public void setNamespace(String namespace){
        this.namespace = namespace;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }
    @Override
    protected void append(LoggingEvent event) {
        String message = this.getLayout().format(event);
        System.out.println(namespace+","+topic+","+message);
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
