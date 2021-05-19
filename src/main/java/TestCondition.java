import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {
    private static AtomicInteger shareData = new AtomicInteger(0);
    private static boolean dataUsed = false;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    public static void change(){
        lock.lock();
        try {
            while (!dataUsed) {
                condition.await();
            }
            if(!isMax()) {
                Thread.sleep(1000);
                dataUsed = false;
                shareData.incrementAndGet();
                System.out.println("product the new value:" + shareData.toString());
                condition.signal();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }
    public static void use(){
        lock.lock();
        try {
            while (dataUsed) {
                condition.await();
            }
            if(!isMax()) {
                Thread.sleep(1000);
                dataUsed = true;
                shareData.incrementAndGet();
                System.out.println("the share data used:" + shareData.toString());
                condition.signal();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }

    }
    public static Boolean isMax(){
        if("10".equals(shareData.toString())){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        new Thread(()->{
            while(!isMax()){
                change();
            }
        },"producer").start();
        new Thread(()->{
            while(!isMax()){
                use();
            }
        },"Consumer").start();

    }
}
