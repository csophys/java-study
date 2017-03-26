package base.Thread;

import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by csophys on 15/7/20.
 */
public class FutureAndCallableTest {
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void testFuture(){
        FutureTask futureTask= new FutureTask(new Callable() {
            public Object call() throws Exception {
                return UUID.randomUUID();
            }
        });
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFutureInExecutors(){
        Future<Object> objectFuture = executorService.submit(new Callable<Object>() {
            public Object call() throws Exception {
                return Math.random();
            }
        });

        try {
            System.out.println(objectFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFutureCollectorInExecutors(){
        CompletionService completionService = new ExecutorCompletionService(executorService);
        int i=10;
        while(i>0){
            completionService.submit(new Callable<Object>() {
                public Object call() throws Exception {
                    return Math.random();
                }
            });
            i--;
        }

        i=10;

        while (i>0){
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            i--;
        }
    }

}
