import java.util.concurrent.Callable;

public class TestCallable implements Callable {
    private int age ;

    public TestCallable(int age) {
        this.age = age;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return "current age is :"+age;
    }
}
