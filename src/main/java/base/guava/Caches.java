package base.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by csophys on 15/9/20.
 */
public class Caches {

    @Test
    public void testCacheBuilder() throws ExecutionException {
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
        builder.maximumSize(1000);
        builder.expireAfterWrite(1000, TimeUnit.HOURS);
        Cache<Integer, Integer> cache = builder.build();
        cache.put(1, 2);
        /**
         * 不存在，则使用callable的返回值替代
         */
        System.out.println(cache.get(1, new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10;
            }
        }));
        System.out.println(cache.getIfPresent(2));
    }
}
