package base.Map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by csophys on 16/4/13.
 */
public class MapKeyValue {

    @Test
    public void testGetKey(){
        Map map = new ConcurrentHashMap();

        System.out.println(map.containsKey(null));
        map.put("1",null);
        Assert.assertEquals(map.get("1"),null);
        map.put(null,null);
        Assert.assertEquals(map.get(null),null);
    }
}
