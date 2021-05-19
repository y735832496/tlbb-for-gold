import java.util.concurrent.*;

public class TestCallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t = new TestCallable(100);
        for (; ;){
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue(3));
            Future future = threadPoolExecutor.submit(t);
            System.out.println(future.get());
            threadPoolExecutor.shutdown();
        }
//        RedisTemplate redisTemplate = new RedisTemplate();
    }
}

