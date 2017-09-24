package base.oom;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by csophys on 16/8/27.
 */
public class HeapOOM {

    /**
     * -Xms100K -Xmx100K
     *
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    @Test
    public void testNewMultipleObject() {
        ArrayList<String> container = Lists.newArrayList();
        while (true) {
            container.add(new String("我是新对象"));
        }
    }
}
