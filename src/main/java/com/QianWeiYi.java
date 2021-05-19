package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import static com.GetGold.outOrgTimeMiles;

public class QianWeiYi {
    public Map<String,Object> qianWeiYiCoorDinate = new HashMap<String, Object>();//钱唯一像素位置
    public Map<String,Object> getTicketCoorDinate = new HashMap<String, Object>();//领取银票像素位置
    public Map<String,Object> backTicketCoorDinate = new HashMap<String, Object>();//交换银票像素位置
    public Map<String,Object> moveToQianWeiYi = new HashMap<String, Object>();//钱唯一游戏位置

    public Map<String,Object> shopCoorDinate = new HashMap<String, Object>();//商人店铺像素位置
    public Map<String,Object> goodCoorDinate = new HashMap<String, Object>();//货物像素位置
    public Map<String,Object> oppoShopCoorDinate = new HashMap<String, Object>();//买入像素位置
    public Map<String,Object> shopCoorDinateOppo = new HashMap<String, Object>();//买入像素位置
    private Navigation n = new Navigation();


    public QianWeiYi() {
        setBackTicketCoorDinate();
        setGetTicketCoorDinate();
        setQianWeiYiCoorDinate();
        setMoveToQianWeiYi();
        setShopCoorDinate();
        setGoodCoorDinate();
        setOppoShopCoorDinate();
        setShopCoorDinateOppo();
    }

    public Map<String, Object> getQianWeiYiCoorDinate() {
        return qianWeiYiCoorDinate;
    }

    public void setQianWeiYiCoorDinate() {
        qianWeiYiCoorDinate.put("x",1087);
        qianWeiYiCoorDinate.put("y",532);
    }

    public Map<String, Object> getGetTicketCoorDinate() {
        return getTicketCoorDinate;
    }

    public void setGetTicketCoorDinate() {
        getTicketCoorDinate.put("x",70);
        getTicketCoorDinate.put("y",270);
    }

    public Map<String, Object> getBackTicketCoorDinate() {
        return backTicketCoorDinate;
    }

    public void setBackTicketCoorDinate() {
        backTicketCoorDinate.put("x",73);
        backTicketCoorDinate.put("y",293);
    }
    public Map<String, Object> getMoveToQianWeiYi() {
        return moveToQianWeiYi;
    }

    public void sendBackTicket(Robot robot) throws InterruptedException {
        robot.mouseMove((Integer)backTicketCoorDinate.get("x"),(Integer)backTicketCoorDinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }
    public void setMoveToQianWeiYi() {
        moveToQianWeiYi.put("x",147);
        moveToQianWeiYi.put("y",56);
    }
    public void openDialog(Robot robot) throws InterruptedException {
        Thread.sleep(5000);
        robot.mouseMove((Integer)qianWeiYiCoorDinate.get("x"),(Integer)qianWeiYiCoorDinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }
    public void getTicket(Robot robot) throws InterruptedException{
        Thread.sleep(1000);
        robot.mouseMove((Integer)getTicketCoorDinate.get("x"),(Integer) getTicketCoorDinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }

    public void openShop(Robot robot )throws InterruptedException{
        Thread.sleep(1000);
        robot.mouseMove((Integer)shopCoorDinate.get("x"),(Integer)shopCoorDinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }
    public void openShopOppo(Robot robot )throws InterruptedException{
        Thread.sleep(1000);
        robot.mouseMove((Integer)shopCoorDinateOppo.get("x"),(Integer)shopCoorDinateOppo.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }
    public void openOppositeShop(Robot robot) throws  InterruptedException{
        Thread.sleep(1000);
        robot.mouseMove((Integer)oppoShopCoorDinate.get("x"),(Integer)oppoShopCoorDinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
    }

    public Map<String, Object> getShopCoorDinate() {
        return shopCoorDinate;
    }

    public void setShopCoorDinate() {
      shopCoorDinate.put("x",74);
      shopCoorDinate.put("y",424);
    }

    public void setShopCoorDinateOppo(){
        shopCoorDinateOppo.put("x",58);
        shopCoorDinateOppo.put("y",252);
    }
    public Map<String, Object> getGoodCoorDinate() {
        return goodCoorDinate;
    }

    public void setGoodCoorDinate() {
        goodCoorDinate.put("x",814);
        goodCoorDinate.put("y",201);
    }
    public void buySomething(Robot robot) throws InterruptedException {
        robot.mouseMove((Integer) goodCoorDinate.get("x"),(Integer) goodCoorDinate.get("y"));
        CommonUtilForGold.mouthLeftPress(robot);
        CommonUtilForGold.mouthLeftPress(robot);
        CommonUtilForGold.mouthLeftPress(robot);
        CommonUtilForGold.mouthLeftPress(robot);
        CommonUtilForGold.mouthLeftPress(robot);
    }
    public void openOppositeDialog(Robot robot) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        n.moveToOpenButton(robot);//鼠标移动到自动寻路
        CommonUtilForGold.mouthLeftPress(robot);//点击自动寻路
        Thread.sleep(200);
        n.inputCoordinateToNavigation((Integer)moveToQianWeiYi.get("x"),(Integer)moveToQianWeiYi.get("y"),robot);//输入坐标
        n.move(robot);//点击移动
        Thread.sleep(outOrgTimeMiles);
        robot.mouseMove((Integer)qianWeiYiCoorDinate.get("x"),(Integer)qianWeiYiCoorDinate.get("y"));//对话钱唯一
        CommonUtilForGold.mouthLeftPress(robot);//对话钱唯一
    }

    public Map<String, Object> getOppoShopCoorDinate() {
        return oppoShopCoorDinate;
    }

    public void setOppoShopCoorDinate() {
        oppoShopCoorDinate.put("x",75);
        oppoShopCoorDinate.put("y",255);
    }
}
