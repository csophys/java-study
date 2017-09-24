package base.oom;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by csophys on 16/8/27.
 */
public class PermGenOOM {

    /*-XX:MaxPermSize=9M -XX:PermSize=9M*/

    /**
     * JDK1.6及之前有效。1.7及之后无效。不会产生方法区异常现象。方法区异常可以通过模拟动态创建类的形式
     * @param args
     */
    @Test
    public static void main(String[] args) {
        ArrayList<String> container = Lists.newArrayList();
        int i=0;
        while (true) {
            container.add(String.valueOf(i++).intern());
        }

    }
}
