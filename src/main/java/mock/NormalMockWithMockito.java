package mock;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * Created by csophys on 2017/1/18.
 */
public class NormalMockWithMockito {

    public static final String MOCK_KEY = "1";
    public static final String MOCK_VALUE = "3";
    public static final String MOCK_THROW_KEY = "2";

    @Test
    public void mockWithPrepareFix(){
        Map map = mock(Map.class);
        when(map.get(MOCK_KEY)).thenReturn(MOCK_VALUE);
        System.out.println(map.get(MOCK_KEY));
        Assert.assertEquals(MOCK_VALUE,map.get(MOCK_KEY));

        when(map.get(MOCK_THROW_KEY)).thenThrow(new RuntimeException());
        try {
            map.get(MOCK_THROW_KEY);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void mockWithImpl(){
      Map map = mock(Map.class);
        when(map.get(MOCK_KEY)).then(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object firstArg = invocationOnMock.getArguments()[0];
                return "hello,"+firstArg;
            }
        });
        Assert.assertEquals(map.get(MOCK_KEY),"hello,"+MOCK_KEY);
    }

    @Test
    public void verifyMock(){
        Map map =mock(Map.class);
        when(map.get(MOCK_KEY)).thenReturn("3");
        map.get(MOCK_KEY);
        verify(map).get(MOCK_KEY);
        verify(map,atLeastOnce()).get(MOCK_KEY);
    }

    @Test
    public void testSpy(){
        Map<String,String> map = new HashMap();
        Map spy = spy(map);
        when(spy.get(MOCK_KEY)).thenReturn("csophys");
        spy.put(MOCK_KEY,MOCK_VALUE);
        spy.put("0","0");
        Assert.assertEquals(spy.get(MOCK_KEY),"csophys");
        Assert.assertEquals(spy.get("0"),"0");
        Assert.assertEquals(spy.size(),2);
    }
}
