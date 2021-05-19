import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    private Semaphore semaphore = new Semaphore(12);
    public void testSemaphore() throws InterruptedException {
        CyclicBarrier c= new CyclicBarrier(1);
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName()+" start time:"+System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" end time:"+System.currentTimeMillis());
        semaphore.release();
    }

}
