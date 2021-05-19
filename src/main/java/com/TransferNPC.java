package com;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TransferNPC {
    private Map cityOneCoordinate = new HashMap<String ,Integer>();
    private Map cityTwoCoordinate = new HashMap<String ,Integer>();

    public TransferNPC() {
        setCityOneCoordinate();
        setCityTwoCoordinate();
    }

    public Map getCityOneCoordinate() {
        return cityOneCoordinate;
    }

    public void setCityOneCoordinate() {
        cityOneCoordinate.put("x",82);
        cityOneCoordinate.put("y",237);
    }

    public Map getCityTwoCoordinate() {
        return cityTwoCoordinate;
    }

    public void setCityTwoCoordinate() {
        cityTwoCoordinate.put("x",98);
        cityTwoCoordinate.put("y",265);
    }

    public void goToOne(Robot robot) throws InterruptedException {
        robot.mouseMove((Integer)cityOneCoordinate.get("x"),(Integer)cityOneCoordinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
        Thread.sleep(4000);
    }
    public void goToTwo(Robot robot) throws InterruptedException{
        robot.mouseMove((Integer)cityTwoCoordinate.get("x"),(Integer)cityTwoCoordinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
        Thread.sleep(4000);
    }
}
