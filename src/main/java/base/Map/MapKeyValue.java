package base.Map;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csophys on 16/4/13.
 */
public class MapKeyValue {

    @Test
    public void testGetKey(){
        Map map = new HashMap<String,String>();

        map.put("1",null);
        Assert.assertEquals(map.get("1"),null);
        map.put(null,null);
        Assert.assertEquals(map.get(null),null);

    }
}
