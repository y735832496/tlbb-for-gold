package com.model;

public class ClientTest {
    public static void main(String[] args) {
        RaffleActicity ra = new RaffleActicity(1);
        for(int i=0;i<300;i++){
            System.out.println("正在进行第"+i+"次抽奖");
            ra.duductMoney();
            ra.raffle();
        }
    }
}
