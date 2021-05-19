package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Navigation {
    private HashMap<String, Integer> autoButtonCoordinate = new HashMap<>();
    private HashMap<String, Integer> moveButtonCoordinate = new HashMap<>();
    private HashMap<String, Integer> xFieldCoordinate = new HashMap<>();
    private HashMap<String, Integer> yFieldCoordinate = new HashMap<>();
    private static Map autoWindowListOne = new HashMap<String, Integer>();
    private static Map autoWindowListTwo = new HashMap<String, Integer>();
    private static Map autoWindowListThree = new HashMap<String, Integer>();
    private static Map autoWindowListFour = new HashMap<String, Integer>();
    private static Map autoWindowListFive = new HashMap<String, Integer>();
    private static Map autoWindowListSix = new HashMap<String, Integer>();
    private static Map autoWindowListSeven = new HashMap<String, Integer>();
    private static Map autoWindowListEight = new HashMap<String, Integer>();

    static {
        //自动寻路列表1
        autoWindowListOne.put("x", 1803);
        autoWindowListOne.put("y", 323);
        //自动寻路列表2
        autoWindowListTwo.put("x", 1804);
        autoWindowListTwo.put("y", 340);
        //自动寻路列表3
        autoWindowListThree.put("x", 1807);
        autoWindowListThree.put("y", 358);
        //自动寻路列表4
        autoWindowListFour.put("x", 1810);
        autoWindowListFour.put("y", 375);
        //自动寻路列表5
        autoWindowListFive.put("x", 1810);
        autoWindowListFive.put("y", 394);
        //自动寻路列表6
        autoWindowListSix.put("x", 1810);
        autoWindowListSix.put("y", 407);
        //自动寻路列表7
        autoWindowListSeven.put("x", 1812);
        autoWindowListSeven.put("y", 428);
        //自动寻路列表8
        autoWindowListEight.put("x", 1812);
        autoWindowListEight.put("y", 441);
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "autoButtonCoordinate=" + autoButtonCoordinate +
                ", moveButtonCoordinate=" + moveButtonCoordinate +
                ", xFieldCoordinate=" + xFieldCoordinate +
                ", yFieldCoordinate=" + yFieldCoordinate +
                '}';
    }

    public HashMap<String, Integer> getAutoButtonCoordinate() {
        return autoButtonCoordinate;
    }

    public Navigation() {
        setAutoButtonCoordinate();
        setMoveButtonCoordinate();
        setxFieldCoordinate();
        setyFieldCoordinate();
    }

    /**
     * 自动寻路按钮坐标
     */
    public void setAutoButtonCoordinate() {
        autoButtonCoordinate.put("x", 1873);
        autoButtonCoordinate.put("y", 231);
        this.autoButtonCoordinate = autoButtonCoordinate;
    }

    public HashMap<String, Integer> getMoveButtonCoordinate() {
        return moveButtonCoordinate;
    }

    /**
     * 移动按钮坐标
     *
     * @param
     */
    public void setMoveButtonCoordinate() {
        moveButtonCoordinate.put("x", 1886);
        moveButtonCoordinate.put("y", 489);
    }

    public HashMap<String, Integer> getxFieldCoordinate() {
        return xFieldCoordinate;
    }

    public void setxFieldCoordinate() {
        xFieldCoordinate.put("x", 1820);
        xFieldCoordinate.put("y", 490);

    }

    public HashMap<String, Integer> getyFieldCoordinate() {
        return yFieldCoordinate;
    }

    public void setyFieldCoordinate() {
        yFieldCoordinate.put("x", 1854);
        yFieldCoordinate.put("y", 490);
    }

    /****
     * 向navigation输入坐标
     * @param robot
     * @throws InterruptedException
     */
    public void inputCoordinateToNavigation(int x, int y, Robot robot) throws InterruptedException {

//        int xx = getAutoButtonCoordinate().get("x");
//        int yy = getAutoButtonCoordinate().get("y");
//        robot.mouseMove(xx, yy);
//        CommonUtilForGold.mouthLeftPress(robot);
        Thread.sleep(1000);
        robot.mouseMove(getxFieldCoordinate().get("x"), (Integer) getxFieldCoordinate().get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
        inputIntoField(x, robot);

        Thread.sleep(1000);
        robot.mouseMove((Integer) getyFieldCoordinate().get("x"), (Integer) getyFieldCoordinate().get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
        inputIntoField(y, robot);

    }

    public void moveToOpenButton(Robot robot) {
        robot.mouseMove(autoButtonCoordinate.get("x"), autoButtonCoordinate.get("y"));
    }

    public static void inputIntoField(int x, Robot robot) {
        String xxx = x + "";
        char[] xxxx = xxx.toCharArray();
        for (int i = 0; i < xxx.length(); i++) {
            switch (xxxx[i] + "") {
                case "0":
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    break;
                case "1":
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    break;
                case "2":
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    break;
                case "3":
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    break;
                case "4":
                    robot.keyPress(KeyEvent.VK_4);
                    robot.keyRelease(KeyEvent.VK_4);
                    break;
                case "5":
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    break;
                case "6":
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    break;
                case "7":
                    robot.keyPress(KeyEvent.VK_7);
                    robot.keyRelease(KeyEvent.VK_7);
                    break;
                case "8":
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    break;
                case "9":
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    break;
                default:
                    System.err.println("GetGold InputCoordinateToNavigation error ");
                    break;
            }
        }
    }

    public void move(Robot robot) throws InterruptedException {
        robot.mouseMove(this.getMoveButtonCoordinate().get("x"), this.getMoveButtonCoordinate().get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }

    public void getLineAndMove(Robot robot, int line) throws InterruptedException {
        switch (line) {
            case 1:
                robot.mouseMove((Integer) autoWindowListOne.get("x"), (Integer) autoWindowListOne.get("y"));
                break;
            case 2:
                robot.mouseMove((Integer) autoWindowListTwo.get("x"), (Integer) autoWindowListTwo.get("y"));
                break;
            case 3:
                robot.mouseMove((Integer) autoWindowListThree.get("x"), (Integer) autoWindowListThree.get("y"));
                break;
            case 4:
                robot.mouseMove((Integer) autoWindowListFour.get("x"), (Integer) autoWindowListFour.get("y"));
                break;
            case 5:
                robot.mouseMove((Integer) autoWindowListFive.get("x"), (Integer) autoWindowListFive.get("y"));
                break;
            case 6:
                robot.mouseMove((Integer) autoWindowListSix.get("x"), (Integer) autoWindowListSix.get("y"));
                break;
            case 7:
                robot.mouseMove((Integer) autoWindowListSeven.get("x"), (Integer) autoWindowListSeven.get("y"));
                break;
            case 8:
                robot.mouseMove((Integer) autoWindowListEight.get("x"), (Integer) autoWindowListEight.get("y"));
                break;
            default:
                break;
        }
        CommonUtilForGold.mouthLeftPress(robot);

    }
}
