package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BackPack {
    private Map goodTabCoordinate = new HashMap<String ,Integer>();
private static ArrayList<Map<String, Integer>> material = new ArrayList<Map<String,Integer>>();
    static{
        Map map = new HashMap();
        //1
        map.put("x",1672);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1702);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1736);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1773);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1810);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1843);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1883);
        map.put("y",572);
        material.add(map);
        //1
        map = new HashMap();
        map.put("x",1672);
        map.put("y",604);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1702);
        map.put("y",604);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1736);
        map.put("y",604);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1773);
        map.put("y",604);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1810);
        map.put("y",604);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1843);
        map.put("y",604);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1883);
        map.put("y",604);
        material.add(map);

        //1
        map = new HashMap();
        map.put("x",1672);
        map.put("y",641);
        material.add(map);
         //1
        map = new HashMap();
        map.put("x",1702);
        map.put("y",641);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1736);
        map.put("y",641);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1773);
        map.put("y",641);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1810);
        map.put("y",641);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1843);
        map.put("y",641);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1883);
        map.put("y",641);
        material.add(map);

        //1
        map = new HashMap();map.put("x",1672);
        map.put("y",679);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1702);
        map.put("y",679);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1736);
        map.put("y",679);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1773);
        map.put("y",679);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1810);
        map.put("y",679);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1843);
        map.put("y",679);
        material.add(map);
         //1
        map = new HashMap();map.put("x",1883);
        map.put("y",679);
        material.add(map);

        //1                
        map = new HashMap();map.put("x",1672);
        map.put("y",712);
        material.add(map); 
         //1               
        map = new HashMap();map.put("x",1702);
        map.put("y",712);
        material.add(map); 
         //1               
        map = new HashMap();map.put("x",1736);
        map.put("y",712);
        material.add(map); 
         //1               
        map = new HashMap();map.put("x",1773);
        map.put("y",712);
        material.add(map); 
         //1               
        map = new HashMap();map.put("x",1810);
        map.put("y",712);
        material.add(map); 
         //1               
        map = new HashMap();map.put("x",1843);
        map.put("y",712);
        material.add(map); 
         //1               
        map = new HashMap();map.put("x",1883);
        map.put("y",712);
        material.add(map); 

         //1
        map = new HashMap();map.put("x",1672);
         map.put("y",747);
         material.add(map);
          //1
        map = new HashMap(); map.put("x",1702);
         map.put("y",747);
         material.add(map);
          //1
        map = new HashMap();map.put("x",1736);
         map.put("y",747);
         material.add(map);
          //1
        map = new HashMap();map.put("x",1773);
         map.put("y",747);
         material.add(map);
          //1
        map = new HashMap();map.put("x",1810);
         map.put("y",747);
         material.add(map);
          //1
        map = new HashMap(); map.put("x",1843);
         map.put("y",747);
         material.add(map);
          //1
        map = new HashMap(); map.put("x",1883);
         map.put("y",747);
         material.add(map);

    }
    public BackPack() {
        setGoodTabCoordinate();
    }

    public Map getGoodTabCoordinate() {
        return goodTabCoordinate;
    }

    public void setGoodTabCoordinate() {
        goodTabCoordinate.put("x",1719);
        goodTabCoordinate.put("y",540);
    }

    public void openMaterialTab(Robot robot) throws InterruptedException {
        robot.mouseMove((Integer)goodTabCoordinate.get("x"),(Integer)goodTabCoordinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }
    public void salesAllGoods(Robot robot)throws InterruptedException{
        for(Map s : material){
            Thread.sleep(400);
            robot.mouseMove((Integer) s.get("x"),(Integer) s.get("y"));
            CommonUtilForGold.mouthRightPress(robot);
        }
    }
    public void openBackPack(Robot robot) throws InterruptedException {

        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_A);

        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_ALT);
    }
}
