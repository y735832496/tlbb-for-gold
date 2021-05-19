package com;

import java.awt.*;
import java.awt.event.InputEvent;

public class CommonUtilForGold {
    public static void mouthLeftPress(Robot robot) throws InterruptedException {
        Thread.sleep(200);
        //模拟鼠标按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(50);
        //模拟鼠标松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void mouthRightPress(Robot robot) throws InterruptedException {
        Thread.sleep(200);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        Thread.sleep(50);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }
}
