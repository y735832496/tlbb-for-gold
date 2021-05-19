package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/***
 * 使用説明 道具窗口默认位置 大叉在纵列快捷键第五格 啓動脚本距離钱唯一10米 在中等价格开启脚本
 */
public class GetGold {
    private static Map autoWindowX = new HashMap<String, Integer>();//自动寻路x输入框显示器坐标
    private static Map autoWindowY = new HashMap<String, Integer>();//自动寻路y输入框显示器坐标
    private static Map outOrgCoordinate = new HashMap<String, Integer>();
    private static Map toQianWeiYi = new HashMap<String, Integer>();
    public static Integer outOrgTimeMiles = 37000;//出帮用时毫秒
    public static Integer npcTosuzhou = 71000;//npc到苏州毫秒
    public static Integer xihuTotaihu = 66000;//西湖到太湖毫秒
    public static Integer suzhouTosongshan = 79000;//苏州到嵩山毫秒
    public static Integer taihuToluoyang = 101000;//太湖到洛阳毫秒
    public static Integer songshanToyannan = 62000;//嵩山到燕南毫秒
    public static Integer luoyangTonpc = 52000;//洛阳到燕南正东毫秒
    public static QianWeiYi q = new QianWeiYi();
    public static Navigation n = new Navigation();
    public static TransferNPC t = new TransferNPC();
    public static BackPack b = new BackPack();

//    public static int getRandomOneToFour() {
//        return (int) (Math.random() * 100 % 4 + 1);
//    }

    static {
        //出帮数据传送阵游戏坐标
        outOrgCoordinate.put("x", 98);
        outOrgCoordinate.put("y", 157);

        //自动寻路窗口x
        autoWindowX.put("x", 1819);
        autoWindowX.put("y", 486);
        //自动寻路窗口y
        autoWindowY.put("x", 1852);
        autoWindowY.put("y", 486);
    }
    private volatile static int timeZoom = 0; //-1 低时 0-中时 1-高时
    public static void main(String[] args) throws Exception {
        Thread timeThread = new Thread(()->{
            try {
                while (true){
                Thread.sleep(150000);
                if(timeZoom==1){
                    timeZoom=-1;
                }else{
                    timeZoom+=1;
                }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timeThread.start();
        for (int i = 0; i < 8; i++) {
            Long a = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() + "第" + (i + 1) + "次跑商开始");
            Robot robot = new Robot();
            toNorth(robot);//镜头朝北
            getSalesTicket(robot);//领取银票
            buySomething(robot);//买东西
            outOrgnization(robot);//出帮
            xiHuXiNanToSuZhou(robot);//西湖到苏州
            xihuToTaiHu(robot);//苏州到太湖
            suzhouToSongshan(robot);//太湖到嵩山
            taihuToLuoYang(robot);//嵩山到洛阳
            luoyangToYannan(robot);//洛阳到燕南

            luoyangToyannanDong(robot);//燕南到燕南东
            t.goToTwo(robot);//选择第二个城市进入56
            q.openOppositeDialog(robot);//前往钱唯一+打开对话框
            System.out.println(System.currentTimeMillis() + "：到達對岸，总用时间：" + (System.currentTimeMillis() - a));
//            Thread.sleep(6000);//休息1分钟
            while(timeZoom!=1){
                Thread.sleep(1000);
                System.out.println("等待价格刷新至卖出区间...");
            }
            openOppositeShop(robot);//打开商店
            salesGoods(robot);//扫描材料背包卖出
            buySomethingOppo(robot);//打开商店买入
            outOrgnization(robot);//出帮
            zhengdongToluoyang(robot);//从燕南正东到洛阳
            yannanTosongshan(robot);//洛阳到嵩山
            luoyangToTaiHu(robot);//嵩山到太湖
            songshanTosuzhou(robot);//太湖到苏州
            taihuToXihu(robot);//苏州到西湖
            suzhouToXinan(robot);//西湖到西南NpC
            t.goToOne(robot);//选择第一个城市进入
            // Thread.sleep(245000);//不休息
//            Thread.sleep(300000);//休息2.5 +2.5
            gotoQianWeiYi(robot);//去钱唯一那卖东西
            sendBackTicket(robot);//交票

//            while(1800000>System.currentTimeMillis()-a){//30分钟一轮跑商
//                System.out.println("等待下一轮跑商开始");
//                Thread.sleep(1000);
//            }
            System.out.println(System.currentTimeMillis() + "第" + (i + 1) + "次跑商结束");
            System.out.println("本次耗时总耗时：" + (System.currentTimeMillis() - a));
          //  timeThread.
        }
    }

    public static void sendBackTicket(Robot robot) throws InterruptedException {
        q.sendBackTicket(robot);
    }

    /**
     * //去钱唯一那卖东西
     *
     * @param robot
     * @throws InterruptedException
     */
    public static void gotoQianWeiYi(Robot robot) throws InterruptedException {
        openNavigationAndMove((Integer) q.getMoveToQianWeiYi().get("x"), (Integer) q.getMoveToQianWeiYi().get("y"), robot);//前往钱唯一
        Thread.sleep(outOrgTimeMiles);
        toNorth(robot);//镜头朝北
        q.openDialog(robot);//打开对话框
        while(timeZoom!=1){
            Thread.sleep(1000);
            System.out.println("等待价格刷新至卖出区间...");
        }
        q.openShop(robot);//打开商店
        b.openBackPack(robot);//打开背包
        b.openMaterialTab(robot);//打开材料栏
        b.salesAllGoods(robot);//遍历所有格子 卖光卖光
    }

    public static void suzhouToXinan(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 6);
        Thread.sleep(npcTosuzhou);
    }

    public static void taihuToXihu(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 6);
        Thread.sleep(xihuTotaihu);
    }

    public static void songshanTosuzhou(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 4);
        Thread.sleep(suzhouTosongshan);
    }

    public static void luoyangToTaiHu(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 3);
        Thread.sleep(taihuToluoyang);
    }

    public static void yannanTosongshan(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 5);
        Thread.sleep(songshanToyannan);
    }

    public static void zhengdongToluoyang(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 2);
        Thread.sleep(luoyangTonpc);
    }

    public static void salesGoods(Robot robot) throws InterruptedException {
        b.openBackPack(robot);
        b.openMaterialTab(robot);
        b.salesAllGoods(robot);
    }

    public static void openOppositeShop(Robot robot) throws InterruptedException {
        q.openOppositeShop(robot);
    }

    public static void luoyangToyannanDong(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 6);
        Thread.sleep(luoyangTonpc);
    }

    public static void luoyangToYannan(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 6);
        Thread.sleep(songshanToyannan);
    }

    public static void taihuToLuoYang(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 1);
        Thread.sleep(taihuToluoyang);
    }

    public static void suzhouToSongshan(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 3);
        Thread.sleep(suzhouTosongshan);
    }

    public static void xihuToTaiHu(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 5);
        Thread.sleep(xihuTotaihu);
    }

    public static void outOrgnization(Robot robot) throws InterruptedException {
        openNavigationAndMove((Integer) outOrgCoordinate.get("x"), (Integer) outOrgCoordinate.get("y"), robot);
        Thread.sleep(outOrgTimeMiles);
    }

    public static void xiHuXiNanToSuZhou(Robot robot) throws InterruptedException {
        openNavigationAndMove(robot, 3);
        Thread.sleep(npcTosuzhou);
    }

    public static void buySomething(Robot robot) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            q.openShop(robot);
            Thread.sleep(444);
            q.buySomething(robot);
        }
    }

    public static void sellSomething(Robot robot) throws InterruptedException {
        q.openShop(robot);
    }

    public static void buySomethingOppo(Robot robot) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            q.openShopOppo(robot);
            Thread.sleep(444);
            q.buySomething(robot);
        }
    }

    /**
     * c朝北Alt+v
     */
    public static void toNorth(Robot robot) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(200);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(4000);
    }

    /**
     * 领取商票
     */
    public static void getSalesTicket(Robot robot) throws Exception {
        openNavigationAndMove((Integer) q.getMoveToQianWeiYi().get("x"), (Integer) q.getMoveToQianWeiYi().get("y"), robot);
        q.openDialog(robot);
        q.getTicket(robot);
    }


    /**
     * 打开自动导航按钮
     *
     * @param x
     * @param y
     * @param robot
     * @throws InterruptedException
     */
    public static void openNavigationAndMove(int x, int y, Robot robot) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        n.moveToOpenButton(robot);//鼠标移动到自动寻路
        CommonUtilForGold.mouthLeftPress(robot);//点击自动寻路
        n.inputCoordinateToNavigation(x, y, robot);//输入坐标
        n.move(robot);//点击移动
    }


    public static void openNavigationAndMove(Robot robot, int line) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        n.moveToOpenButton(robot);//鼠标移动到自动寻路
        Thread.sleep(2000);
        CommonUtilForGold.mouthLeftPress(robot);//点击自动寻路
        Thread.sleep(2000);
        n.getLineAndMove(robot, line);
        Thread.sleep(2000);
        n.move(robot);
    }

}
