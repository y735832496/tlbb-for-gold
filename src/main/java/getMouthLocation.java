import java.awt.*;

public class getMouthLocation {
    public static void main(String[] args) throws InterruptedException {
        while (1 == 1) {

        Thread.sleep(500);
        Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
        System.err.println(point.x+","+point.y);
        }
    }
}
