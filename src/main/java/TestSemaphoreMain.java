public class TestSemaphoreMain {
    public static void main(String[] args) {
        TestSemaphore testSemaphore = new TestSemaphore();
        Thread1 t1 = new Thread1(testSemaphore);
        Thread1 t2 = new Thread1(testSemaphore);
        Thread1 t3 = new Thread1(testSemaphore);
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Thread1 extends Thread{
    private TestSemaphore testSemaphore;
    public Thread1(TestSemaphore testSemaphore){
        super();
        this.testSemaphore = testSemaphore;
    }

    @Override
    public void run() {
        try {
            testSemaphore.testSemaphore();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Thread2 extends Thread{
    private TestSemaphore testSemaphore;
    public Thread2(TestSemaphore testSemaphore){
        super();
        this.testSemaphore = testSemaphore;
    }

    @Override
    public void run() {
        try {
            testSemaphore.testSemaphore();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread3 extends Thread{
    private TestSemaphore testSemaphore;
    public Thread3(TestSemaphore testSemaphore){
        super();
        this.testSemaphore = testSemaphore;
    }

    @Override
    public void run() {
        try {
            testSemaphore.testSemaphore();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}