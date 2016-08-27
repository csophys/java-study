package base.oom;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by csophys on 16/8/27.
 */
public class PermGenOOM {

    /*-XX:MaxPermSize=9M -XX:PermSize=9M*/
    @Test
    public void addPermString() {
        ArrayList<String> container = Lists.newArrayList();
        long i=0;
        while (true) {
            new String(String.valueOf(i++)).intern();
        }
    }
}
