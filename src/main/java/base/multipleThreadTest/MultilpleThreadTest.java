package base.multipleThreadTest;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by csophys on 16/3/23.
 */
public class MultilpleThreadTest {

    @Test
    public void testMultile() {

        await().atMost(3, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(1000);
                return true;
            }
        }, equalTo(true));

    }
}
